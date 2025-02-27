package com.ajailani.presentation_android.feature_one.screen.item_detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajailani.kmpmultimodule.api.one.domain.use_case.GetItemUseCase
import com.ajailani.kmpmultimodule.core.network.util.ApiResult
import kotlinx.coroutines.launch

class ItemDetailViewModel(
    private val getItemUseCase: GetItemUseCase
) : ViewModel() {
    var uiState by mutableStateOf(ItemDetailUiState())
        private set

    fun getItemDetail() {
        uiState = uiState.copy(isLoading = true)

        viewModelScope.launch {
            getItemUseCase().collect {
                uiState = when (it) {
                    is ApiResult.Success -> {
                        uiState.copy(
                            isLoading = false,
                            item = it.data
                        )
                    }

                    is ApiResult.Error -> {
                        uiState.copy(
                            isLoading = false,
                            errorMessage = it.message
                        )
                    }
                }
            }
        }
    }
}