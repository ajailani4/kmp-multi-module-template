dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("libs").from(files("../gradle/libs.versions.toml"))
        create("config").from(files("../gradle/config.versions.toml"))
    }
}

rootProject.name = "buildSrc"