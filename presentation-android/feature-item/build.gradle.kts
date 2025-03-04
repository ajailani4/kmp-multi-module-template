plugins {
    `compose-convention`
}

dependencies {
    implementation(projects.core.entity)
    implementation(projects.core.network)
    implementation(projects.api.item)
}