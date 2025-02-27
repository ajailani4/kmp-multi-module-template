package com.ajailani.kmpmultimodule.core.network.util

sealed class ApiResult<T> {
    data class Success<T>(val data: T? = null) : ApiResult<T>()
    data class Error<T>(val message: String? = null) : ApiResult<T>()
}
