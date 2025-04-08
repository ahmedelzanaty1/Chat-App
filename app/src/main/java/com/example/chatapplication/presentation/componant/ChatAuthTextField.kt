package com.example.chatapplication.presentation.componant

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.chatapplication.presentation.theme.mainblue

@Composable
fun ChatAuthTextField(modifier: Modifier = Modifier
                      , state : MutableState<String>
                      , error : String, label : String) {
    Column(modifier = modifier.fillMaxWidth() , horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(value = state.value, onValueChange = { newvalue ->
            state.value = newvalue

        }, modifier = modifier.fillMaxWidth(.85F), colors = TextFieldDefaults.colors(
            errorIndicatorColor = Color.Red,
            focusedIndicatorColor = mainblue,
            unfocusedIndicatorColor = Color.Gray,
            focusedLabelColor = mainblue,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent
            , errorContainerColor = Color.Transparent
        )
            , label = { Text(text = label) }
        )
        if (error.isNotEmpty()) {
            Text(text = error, color = Color.Red)
        }

    }
}