package com.ajailani.kmpmultimodule.di

import org.koin.dsl.module

val appModule = module {
    includes(networkModule)
}