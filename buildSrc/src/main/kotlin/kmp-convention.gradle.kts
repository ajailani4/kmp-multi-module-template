import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import util.PackageConfig
import util.diCommonDependencies

val config: VersionCatalog = the<VersionCatalogsExtension>().named("config")

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.multiplatform")
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
            baseName = project.path
                .split("[:\\-]".toRegex())
                .joinToString("") { it.replaceFirstChar { char -> char.uppercaseChar() } }

            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            diCommonDependencies()
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
