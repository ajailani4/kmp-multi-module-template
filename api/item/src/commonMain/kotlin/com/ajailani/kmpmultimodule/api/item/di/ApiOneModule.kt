package com.ajailani.kmpmultimodule.api.item.di

import com.ajailani.kmpmultimodule.api.item.data.remote.api_service.ExampleService
import com.ajailani.kmpmultimodule.api.item.data.remote.data_source.ExampleRemoteDataSource
import com.ajailani.kmpmultimodule.api.item.data.repository.ExampleRepositoryImpl
import com.ajailani.kmpmultimodule.api.item.domain.repository.ExampleRepository
import com.ajailani.kmpmultimodule.api.item.domain.use_case.GetItemUseCase
import org.koin.dsl.module

val apiOneModule = module {
    single { ExampleService(get()) }
    single { ExampleRemoteDataSource(get()) }
    single<ExampleRepository> { ExampleRepositoryImpl(get()) }

    // Use case
    single { GetItemUseCase(get()) }
}