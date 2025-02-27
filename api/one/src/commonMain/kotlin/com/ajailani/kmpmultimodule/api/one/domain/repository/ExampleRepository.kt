package com.ajailani.kmpmultimodule.api.one.domain.repository

import com.ajailani.kmpmultimodule.core.entity.ExampleItem
import com.ajailani.kmpmultimodule.core.network.util.ApiResult
import kotlinx.coroutines.flow.Flow

interface ExampleRepository {
    fun getExampleItem(): Flow<ApiResult<ExampleItem>>
}