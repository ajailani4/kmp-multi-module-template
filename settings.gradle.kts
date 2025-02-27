import java.io.FileInputStream
import java.util.Properties

rootProject.name = "KMPMultiModule"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }

    versionCatalogs {
        create("config").from(files("gradle/config.versions.toml"))
    }
}

include(":composeApp")

Properties().apply {
    load(FileInputStream(File("$rootDir/module.properties")))
    entries.forEach {
        if (it.value.toString().isBlank()) {
            val moduleKey = it.key.toString().split(".")
            include(if (moduleKey.size == 1) moduleKey[0] else "${moduleKey[0]}:${moduleKey[1]}")
        }
    }
}