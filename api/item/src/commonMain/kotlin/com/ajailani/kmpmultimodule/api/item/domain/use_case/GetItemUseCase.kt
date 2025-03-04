package com.ajailani.kmpmultimodule.api.item.domain.use_case

import com.ajailani.kmpmultimodule.api.item.domain.repository.ExampleRepository

class GetItemUseCase(private val repository: ExampleRepository) {
    operator fun invoke() = repository.getExampleItem()
}