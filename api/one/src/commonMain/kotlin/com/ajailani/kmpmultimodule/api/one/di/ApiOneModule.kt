package com.ajailani.kmpmultimodule.api.one.di

import com.ajailani.kmpmultimodule.api.one.data.remote.api_service.ExampleService
import com.ajailani.kmpmultimodule.api.one.data.remote.data_source.ExampleRemoteDataSource
import com.ajailani.kmpmultimodule.api.one.data.repository.ExampleRepositoryImpl
import com.ajailani.kmpmultimodule.api.one.domain.repository.ExampleRepository
import com.ajailani.kmpmultimodule.api.one.domain.use_case.GetItemUseCase
import org.koin.dsl.module

val apiOneModule = module {
    single { ExampleService(get()) }
    single { ExampleRemoteDataSource(get()) }
    single<ExampleRepository> { ExampleRepositoryImpl(get()) }

    // Use case
    single { GetItemUseCase(get()) }
}