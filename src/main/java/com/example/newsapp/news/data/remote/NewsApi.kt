package com.example.newsapp.news.data.remote

import com.example.newsapp.news.domain.model.NewResponse
import com.example.newsapp.news.domain.model.News
import com.example.newsapp.util.Constants
import retrofit2.http.GET
import retrofit2.http.Query




interface NewsApi {
    @GET("everything")
    suspend fun getArticles(
        @Query("q") query: String, 
        @Query("from") from: String, 
        @Query("sortBy") sortBy: String = "publishedAt",
        @Query("apiKey") apiKey: String = Constants.API_KEY 
    ): News
}
