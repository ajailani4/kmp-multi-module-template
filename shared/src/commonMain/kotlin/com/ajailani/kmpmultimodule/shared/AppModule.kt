package com.ajailani.kmpmultimodule.shared

import com.ajailani.kmpmultimodule.api.item.di.apiOneModule
import com.ajailani.kmpmultimodule.core.network.di.networkModule
import org.koin.dsl.module

val appModule = module {
    includes(
        networkModule,
        apiOneModule
    )
}