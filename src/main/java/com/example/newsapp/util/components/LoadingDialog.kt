package com.example.newsapp.util.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@androidx.compose.runtime.Composable
fun LoadingDialog(
    isLoading:Boolean
){
    if(isLoading){
        androidx.compose.ui.window.Dialog(
            onDismissRequest = { /*TODO*/ },
            properties = androidx.compose.ui.window.DialogProperties(dismissOnClickOutside = false)
        ) {
            androidx.compose.foundation.layout.Box(
                modifier = androidx.compose.ui.Modifier.Companion
                    .width(200.dp)
                    .clip(androidx.compose.foundation.shape.RoundedCornerShape(15.dp))
                    .background(androidx.compose.ui.graphics.Color.Companion.White),
                contentAlignment = androidx.compose.ui.Alignment.Companion.Center
            ) {
                androidx.compose.material3.CircularProgressIndicator(
                    modifier = androidx.compose.ui.Modifier.Companion.padding(
                        10.dp
                    )
                )
            }
        }
    }
}