plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
    implementation(libs.android.gradle.plugin)
    implementation(libs.cmp.plugin)
    implementation(libs.compose.compiler.plugin)
    implementation(libs.kmp.plugin)
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.kotlin.serialization.plugin)
}