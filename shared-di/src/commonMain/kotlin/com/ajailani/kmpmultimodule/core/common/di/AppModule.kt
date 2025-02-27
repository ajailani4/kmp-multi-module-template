package com.ajailani.kmpmultimodule.core.common.di

import com.ajailani.kmpmultimodule.api.one.di.apiOneModule
import com.ajailani.kmpmultimodule.core.network.di.networkModule
import org.koin.dsl.module

val appModule = module {
    includes(
        networkModule,
        apiOneModule
    )
}