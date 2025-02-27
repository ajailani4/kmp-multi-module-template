plugins {
    `kmp-convention`
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.network)
            implementation(projects.api.one)
        }
    }
}