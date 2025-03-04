package com.ajailani.presentation_android.feature_item.screen.item_detail

import com.ajailani.kmpmultimodule.core.entity.ExampleItem

data class ItemDetailUiState(
    val isLoading: Boolean = false,
    val item: ExampleItem? = null,
    val errorMessage: String? = null
)
