import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import util.PackageConfig
import util.diCommonDependencies

plugins {
    id(libs.plugins.kotlinMultiplatform.get().pluginId)
    id(libs.plugins.androidLibrary.get().pluginId)
    id(libs.plugins.kotlinSerialization.get().pluginId)
    id(libs.plugins.touchlabSkie.get().pluginId)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true

            // Export modules to iOS app
            export(projects.core)
            export(projects.api)
        }
    }

    sourceSets {
        commonMain.dependencies {
            diCommonDependencies()
            api(projects.core.network)
            api(projects.api.item)
        }
    }
}

android {
    namespace = "${PackageConfig.projectNamespace}.${project.name.replace("-", "_")}"
    compileSdk = config.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = config.versions.android.minSdk.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}