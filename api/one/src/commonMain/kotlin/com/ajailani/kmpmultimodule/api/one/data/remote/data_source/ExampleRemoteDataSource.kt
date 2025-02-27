package com.ajailani.kmpmultimodule.api.one.data.remote.data_source

import com.ajailani.kmpmultimodule.api.one.data.remote.api_service.ExampleService

class ExampleRemoteDataSource(private val service: ExampleService) {
    suspend fun getItem() = service.getItem()
}