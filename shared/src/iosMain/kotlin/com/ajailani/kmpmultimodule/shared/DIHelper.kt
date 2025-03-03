package com.ajailani.kmpmultimodule.shared

import com.ajailani.kmpmultimodule.api.one.domain.use_case.GetItemUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

class DIHelper : KoinComponent {
    fun initKoin() {
        startKoin {
            modules(appModule)
        }
    }

    val getItemUseCase by inject<GetItemUseCase>()
}