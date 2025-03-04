package com.ajailani.kmpmultimodule.api.item.data.remote.api_service

import io.ktor.client.HttpClient
import io.ktor.client.request.get

class ExampleService(private val httpClient: HttpClient) {
    suspend fun getItem() = httpClient.get("example-item")
}