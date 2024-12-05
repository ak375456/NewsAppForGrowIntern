package com.example.newsapp.news.domain.repository

import arrow.core.Either
import com.example.newsapp.news.domain.model.Article
import com.example.newsapp.news.domain.model.NetworkError

interface NewsRepository {
    suspend fun getNews(): Either<NetworkError, List<Article>>
}