plugins {
    id("base-convention")
    id("kotlinx-serialization")
    id("kotlin-parcelize")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            networkCommonDependencies()
        }

        androidMain.dependencies {
            networkAndroidDependencies()
        }

        iosMain.dependencies {
            networkIosDependencies()
        }
    }
}