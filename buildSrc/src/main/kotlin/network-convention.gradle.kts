import util.networkAndroidDependencies
import util.networkCommonDependencies
import util.networkIosDependencies

plugins {
    id("kmp-convention")
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