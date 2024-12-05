package com.example.newsapp.news.presenetation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.util.EventBus
import kotlinx.coroutines.launch

fun ViewModel.sendEvents(event:Any){
    viewModelScope.launch {
        EventBus.sendEvent(event)
    }
}