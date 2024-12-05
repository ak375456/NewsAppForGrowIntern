package com.example.newsapp.news.presenetation.news_screen

import com.example.newsapp.news.domain.model.Article

data class NewsViewState(
    val isLoading:Boolean = false,
    val news: List<Article> = emptyList(),
    val error:String? = null
)
