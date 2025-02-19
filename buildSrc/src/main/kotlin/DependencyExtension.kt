import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.compose.ComposeExtension
import org.jetbrains.compose.ComposePlugin
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

val KotlinDependencyHandler.libs: LibrariesForLibs
    get() = project.extensions.getByType(LibrariesForLibs::class.java)

val KotlinDependencyHandler.composeDeps: ComposePlugin.Dependencies
    get() = project.extensions.getByType<ComposeExtension>().dependencies

fun KotlinDependencyHandler.diDependencies() {
    implementation(project.dependencies.platform(libs.koin.bom))
    implementation(libs.koin.core)
}

fun KotlinDependencyHandler.networkCommonDependencies() {
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.logging)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.client.json.serialization)

    implementation(libs.kotlinx.serialization.json)
}

fun KotlinDependencyHandler.networkAndroidDependencies() {
    implementation(libs.ktor.client.android)
}

fun KotlinDependencyHandler.networkIosDependencies() {
    implementation(libs.ktor.client.darwin)
}

fun KotlinDependencyHandler.composeAndroidDependencies() {
    implementation(composeDeps.preview)
    implementation(libs.androidx.activity.compose)
}

fun KotlinDependencyHandler.composeCommonDependencies() {
    implementation(composeDeps.runtime)
    implementation(composeDeps.foundation)
    implementation(composeDeps.material)
    implementation(composeDeps.ui)
    implementation(composeDeps.components.resources)
    implementation(composeDeps.components.uiToolingPreview)
    implementation(libs.androidx.lifecycle.viewmodel)
    implementation(libs.androidx.lifecycle.runtime.compose)
}
