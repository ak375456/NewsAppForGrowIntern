package com.example.newsapp.news.domain.model

data class News(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)