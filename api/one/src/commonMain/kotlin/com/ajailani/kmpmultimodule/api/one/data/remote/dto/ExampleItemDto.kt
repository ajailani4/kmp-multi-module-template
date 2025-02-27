package com.ajailani.kmpmultimodule.api.one.data.remote.dto

import com.ajailani.kmpmultimodule.core.entity.ExampleItem
import kotlinx.serialization.Serializable

@Serializable
data class ExampleItemDto(
    val id: String,
    val name: String
) {
    fun mapToEntity() = ExampleItem(id, name)
}