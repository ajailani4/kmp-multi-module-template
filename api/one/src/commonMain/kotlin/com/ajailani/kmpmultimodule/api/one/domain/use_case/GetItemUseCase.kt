package com.ajailani.kmpmultimodule.api.one.domain.use_case

import com.ajailani.kmpmultimodule.api.one.domain.repository.ExampleRepository

class GetItemUseCase(private val repository: ExampleRepository) {
    operator fun invoke() = repository.getExampleItem()
}