import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import util.PackageConfig
import util.composeAndroidDependencies
import util.composeCommonDependencies
import util.diAndroidDependencies

plugins {
    id(libs.plugins.kotlinMultiplatform.get().pluginId)
    id(libs.plugins.androidApplication.get().pluginId)
    id(libs.plugins.composeMultiplatform.get().pluginId)
    id(libs.plugins.composeCompiler.get().pluginId)
    id(libs.plugins.kotlinSerialization.get().pluginId)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    sourceSets {
        androidMain.dependencies {
            composeAndroidDependencies()
            diAndroidDependencies()

            implementation(projects.presentationAndroid.featureOne)
        }

        commonMain.dependencies {
            composeCommonDependencies()
            implementation(projects.shared)
        }
    }
}

android {
    namespace = PackageConfig.projectNamespace
    compileSdk = config.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = PackageConfig.applicationId
        minSdk = config.versions.android.minSdk.get().toInt()
        targetSdk = config.versions.android.targetSdk.get().toInt()
        versionCode = config.versions.android.versionCode.get().toInt()
        versionName = config.versions.android.versionName.get()
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
}

