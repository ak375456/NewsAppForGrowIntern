package com.example.newsapp.news.data.repository

import android.util.Log
import arrow.core.Either
import com.example.newsapp.news.data.mapper.toNetworkError
import com.example.newsapp.news.data.remote.NewsApi
import com.example.newsapp.news.domain.model.Article
import com.example.newsapp.news.domain.model.NetworkError
import com.example.newsapp.news.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsApi: NewsApi
) : NewsRepository {
    override suspend fun getNews(): Either<NetworkError, List<Article>> {
        return Either.catch {
            val response = newsApi.getArticles(
                query = "all",
                from = "2024-11-05",
                sortBy = "publishedAt"
            )
            response.articles
        }.mapLeft {
            Log.d("ERRORRR", "getNews: $it")
            it.toNetworkError()
        }
    }
}
