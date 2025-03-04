plugins {
    `network-convention`
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.network)
            implementation(projects.core.entity)
        }
    }
}