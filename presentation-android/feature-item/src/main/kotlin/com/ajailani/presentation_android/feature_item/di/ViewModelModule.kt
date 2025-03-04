package com.ajailani.presentation_android.feature_item.di

import com.ajailani.presentation_android.feature_item.screen.item_detail.ItemDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureOneViewModelModule = module {
    viewModel { ItemDetailViewModel(get()) }
}