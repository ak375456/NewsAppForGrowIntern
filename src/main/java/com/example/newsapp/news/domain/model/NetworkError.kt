package com.example.newsapp.news.domain.model

import android.R.id.message

data class NetworkError (
    val error: ApiError,
    val t:Throwable? = null
)

enum class ApiError(val message:String) {
    NetworkError("Network Error $message"),
    UnKnownResponse("Unknown Response $message"),
    UnknownError("Unknown Error $message")
}