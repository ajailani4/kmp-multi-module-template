package com.ajailani.kmpmultimodule.core.network.di

import com.ajailani.kmpmultimodule.core.network.util.ktorEngine
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.URLProtocol
import io.ktor.http.path
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val networkModule = module {
    single {
        HttpClient(ktorEngine) {
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        println("Ktor Log: $message")
                    }
                }
            }

            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    ignoreUnknownKeys = true
                    encodeDefaults = true
                })
            }

            defaultRequest {
                url {
                    protocol = URLProtocol.HTTP
                    host = "10.54.149.101"
                    path("example/v1/")
                }
            }
        }
    }
}