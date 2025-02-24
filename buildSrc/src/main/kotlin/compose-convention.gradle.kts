import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import util.PackageConfig
import util.composeAndroidDependencies
import util.diAndroidDependencies
import util.diCommonDependencies

val config: VersionCatalog = the<VersionCatalogsExtension>().named("config")

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.multiplatform")
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.compose")
    id("kotlinx-serialization")
    id("kotlin-parcelize")
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    sourceSets {
        androidMain.dependencies {
            diCommonDependencies()
            diAndroidDependencies()
            composeAndroidDependencies()
        }
    }
}

android {
    namespace = "${PackageConfig.projectNamespace}.${project.name.replace("-", "_")}"
    compileSdk = config.findVersion("android-compileSdk").get().toString().toInt()

    defaultConfig {
        minSdk = config.findVersion("android-minSdk").get().toString().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
}