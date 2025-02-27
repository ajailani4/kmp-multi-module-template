package com.ajailani.kmpmultimodule.api.one.data.repository

import com.ajailani.kmpmultimodule.api.one.data.remote.data_source.ExampleRemoteDataSource
import com.ajailani.kmpmultimodule.api.one.data.remote.dto.ExampleItemDto
import com.ajailani.kmpmultimodule.api.one.domain.repository.ExampleRepository
import com.ajailani.kmpmultimodule.core.network.util.ApiResult
import io.ktor.client.call.body
import io.ktor.http.HttpStatusCode.Companion.InternalServerError
import io.ktor.http.HttpStatusCode.Companion.OK
import kotlinx.coroutines.flow.flow

class ExampleRepositoryImpl(private val remoteDataSource: ExampleRemoteDataSource) : ExampleRepository {
    override fun getExampleItem() = flow {
        val response = remoteDataSource.getItem()

        when (response.status) {
            OK -> {
                val responseBody = response.body<ExampleItemDto>()
                emit(ApiResult.Success(responseBody.mapToEntity()))
            }

            InternalServerError -> emit(ApiResult.Error("Server error"))

            else -> emit(ApiResult.Error("Sorry, something wrong happened"))
        }
    }
}