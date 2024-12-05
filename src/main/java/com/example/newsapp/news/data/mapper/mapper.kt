package com.example.newsapp.news.data.mapper

import com.example.newsapp.news.domain.model.ApiError
import com.example.newsapp.news.domain.model.NetworkError
import okio.IOException
import retrofit2.HttpException

fun Throwable.toNetworkError() :NetworkError {
    val error = when(this){
        is IOException-> ApiError.NetworkError
        is HttpException->ApiError.UnKnownResponse
        else -> ApiError.UnknownError
    }
    return NetworkError(
        error = error,
        t = this
    )
}