package com.ajailani.kmpmultimodule.di

import di.networkModule
import org.koin.dsl.module

val appModule = module {
    includes(networkModule)
}