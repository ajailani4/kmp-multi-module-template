import org.jetbrains.kotlin.gradle.dsl.JvmTarget

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
}

dependencies {
    debugImplementation(compose.uiTooling)
}

