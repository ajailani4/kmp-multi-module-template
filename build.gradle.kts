plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    id(libs.plugins.androidApplication.get().pluginId) apply false
    id(libs.plugins.androidLibrary.get().pluginId) apply false
    id(libs.plugins.composeMultiplatform.get().pluginId) apply false
    id(libs.plugins.composeCompiler.get().pluginId) apply false
    id(libs.plugins.kotlinMultiplatform.get().pluginId) apply false
    id(libs.plugins.jetbrainsKotlinJvm.get().pluginId) apply false
    id(libs.plugins.kotlinAndroid.get().pluginId) apply false
}