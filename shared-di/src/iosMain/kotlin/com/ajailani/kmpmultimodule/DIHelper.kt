package com.ajailani.kmpmultimodule

import com.ajailani.kmpmultimodule.core.common.di.appModule
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin

class DIHelper : KoinComponent {
    fun initKoin() {
        startKoin {
            modules(appModule)
        }
    }
}