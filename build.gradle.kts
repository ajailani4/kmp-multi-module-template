import java.io.FileInputStream
import java.util.Properties

plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    id(libs.plugins.androidApplication.get().pluginId) apply false
    id(libs.plugins.androidLibrary.get().pluginId) apply false
    id(libs.plugins.composeMultiplatform.get().pluginId) apply false
    id(libs.plugins.composeCompiler.get().pluginId) apply false
    id(libs.plugins.kotlinMultiplatform.get().pluginId) apply false
    id(libs.plugins.jetbrainsKotlinJvm.get().pluginId) apply false
    id(libs.plugins.kotlinAndroid.get().pluginId) apply false
}

private val modules = mutableListOf<String>()

Properties().apply {
    load(FileInputStream(File("$rootDir/module.properties")))

    entries.forEach {
        val moduleKey = it.key.toString().split(".")
        modules.add(":${moduleKey[0]}:${moduleKey[1]}")
    }
}

tasks.register("embedAndSignAppleFrameworkForXcode") {
    modules
        .filter { !it.contains("presentation-android") }
        .forEach {
            dependsOn("$it:embedAndSignAppleFrameworkForXcode")
        }
}