import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id(libs.plugins.kotlinMultiplatform.get().pluginId)
    id(libs.plugins.androidLibrary.get().pluginId)
    id(libs.plugins.kotlinSerialization.get().pluginId)
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
        }
    }
    
    sourceSets {
        commonMain.dependencies {
            sharedCommonDependencies()
        }

        androidMain.dependencies {
            sharedAndroidDependencies()
        }

        iosMain.dependencies {
            sharedIosDependencies()
        }
    }
}

android {
    namespace = PackageConfig.projectNamespace
    compileSdk = config.versions.android.compileSdk.get().toInt()

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    defaultConfig {
        minSdk = config.versions.android.minSdk.get().toInt()
    }
}
