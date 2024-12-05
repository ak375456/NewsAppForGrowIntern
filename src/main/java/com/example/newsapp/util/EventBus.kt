package com.example.newsapp.util

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

object EventBus {
    private val _events = Channel<Any>()
    val events = _events.receiveAsFlow()

    suspend fun sendEvent(event:Any) {
        _events.send(event)
    }
}

sealed interface Event{
    data class Toast(val message:String):Event
    data class SnackBar(val message:String):Event
    data class Dialog(val message:String):Event
}