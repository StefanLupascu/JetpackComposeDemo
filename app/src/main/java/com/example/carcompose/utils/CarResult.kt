package com.example.carcompose.utils

import retrofit2.HttpException

sealed class CarResult<out T> {
    data class Success<out T>(val value: T) : CarResult<T>()
    data class NetworkError<out T>(val exception: HttpException) : CarResult<T>()
    object UnknownError : CarResult<Nothing>()
}

suspend fun <T> wrapIntoResult(function: suspend () -> T): CarResult<T> = try {
    CarResult.Success(function())
} catch (exception: HttpException) {
    CarResult.NetworkError(exception)
} catch (exception: Exception) {
    CarResult.UnknownError
}