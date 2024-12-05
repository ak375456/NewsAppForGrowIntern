package com.example.newsapp.news.presenetation.news_screen

import NewsCard
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.newsapp.util.components.LoadingDialog


@Composable
internal fun NewsScreen(
    viewModel: NewsViewModel = hiltViewModel()
){
    val state by viewModel.state.collectAsStateWithLifecycle()
    NewsContent(state = state)

}
@Composable
fun NewsContent(state: NewsViewState){
    LoadingDialog(isLoading = state.isLoading)
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            LazyColumn (
                modifier = Modifier.fillMaxSize()
            ){
                items(state.news){news->
                    NewsCard(new = news)

                }
            }
        }
    }
}