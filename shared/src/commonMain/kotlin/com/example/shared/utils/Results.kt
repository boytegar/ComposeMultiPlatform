package com.example.shared.utils

sealed class Results<T> {
    class Loading<T> : Results<T>()
    class Empty<T> : Results<T>()
    data class Success<T>(val data: T) : Results<T>()
    data class Failure<T>(val throwable: Throwable?, val message: String?) : Results<T>()
    data class Connection<T>(val message: String?) : Results<T>()
    data class Error<T>(val code: Int?, val message: String?) : Results<T>()
    companion object {
        fun <T> loading(): Results<T> = Loading()
        fun <T> empty(): Results<T> = Empty()
        fun <T> success(data: T): Results<T> = Success(data)
        fun <T> fail(throwable: Throwable, message: String?): Results<T> = Failure(throwable, message)
        fun <T> error(code: Int?, message: String): Results<T> = Error(code, message)
        fun <T> connection(message: String?): Results<T> = Connection(message)
    }
}
