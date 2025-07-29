package com.example.shared.utils

import kotlinx.coroutines.flow.Flow

sealed class ResultState<out T> {
    object Loading : ResultState<Nothing>()
    data class Success<out T>(val data: T) : ResultState<T>()
    data class Error(
        val message: String,
        val code: Int? = null,
        val exception: Throwable? = null
    ) : ResultState<Nothing>()
}

suspend fun <T> Flow<ResultState<T>>.handleResult(
    onSuccess: (T) -> Unit,
    onError: (code: Int?, message: String) -> Unit,
    onLoading: (() -> Unit)? = null,
) {
    this.collect { resultState ->
        when (resultState) {
            is ResultState.Loading -> onLoading?.invoke()
            is ResultState.Success -> onSuccess(resultState.data)
            is ResultState.Error -> onError(resultState.code, resultState.message)
        }
    }
}