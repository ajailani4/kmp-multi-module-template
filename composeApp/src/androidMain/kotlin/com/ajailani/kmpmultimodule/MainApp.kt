package com.ajailani.kmpmultimodule

import android.app.Application
import com.ajailani.kmpmultimodule.shared.appModule
import com.ajailani.presentation_android.feature_item.di.featureOneViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApp)
            modules(appModule, featureOneViewModelModule)
        }
    }
}