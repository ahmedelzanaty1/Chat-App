package com.example.chatapplication.presentation.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.chatapplication.presentation.theme.mainblue

@Composable
fun LoadingDialogs(showLoading : MutableState<Boolean>, modifier: Modifier = Modifier) {
    if (showLoading.value){
        Dialog(onDismissRequest = { showLoading.value = false }) {
            Box (modifier = modifier
                .size(100.dp)
                .background(Color.White, RoundedCornerShape(15.dp))
                , contentAlignment = Alignment.Center
            ){
                CircularProgressIndicator(color = mainblue)
            }
        }
    }
}

@Composable
fun ErrorDialog(error: MutableState<String>, modifier: Modifier = Modifier) {
    if (error.value.isNotEmpty()) {
        AlertDialog(
            onDismissRequest = { error.value = "" },
            confirmButton = {
                TextButton(onClick = { error.value = "" }) {
                    Text(text = "OK")
                }
            },
            text = {
                Text(text = error.value)
            },
            modifier = modifier
        )
    }
}


