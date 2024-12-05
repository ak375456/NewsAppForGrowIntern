package com.example.newsapp.news.data.remote

import com.example.newsapp.news.domain.model.NewResponse
import com.example.newsapp.news.domain.model.News
import com.example.newsapp.util.Constants
import retrofit2.http.GET
import retrofit2.http.Query




interface NewsApi {
    @GET("everything")
    suspend fun getArticles(
        @Query("q") query: String, // The keyword for the search, e.g., "tesla"
        @Query("from") from: String, // The start date for news articles, e.g., "2024-11-05"
        @Query("sortBy") sortBy: String = "publishedAt", // Sorting order, default is "publishedAt"
        @Query("apiKey") apiKey: String = Constants.API_KEY // API key for authentication
    ): News // This should return a NewResponse object with the actual structure
}
