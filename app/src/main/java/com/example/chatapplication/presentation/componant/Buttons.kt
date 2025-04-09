package com.example.chatapplication.presentation.componant

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.chatapplication.R
import com.example.chatapplication.presentation.theme.mainblue

@Composable
fun AuthButtons(title : String , onClick : () -> Unit ,modifier: Modifier = Modifier) {
    Button(onClick = onClick, colors = ButtonDefaults.buttonColors(
        containerColor = mainblue,
        contentColor = Color.White
    ), modifier = Modifier.fillMaxWidth(.85F),
         shape = RoundedCornerShape(12.dp)
    ) {
        Text(text = title)
        Spacer(modifier = modifier.weight(1F))
        Image(painter = painterResource(id = R.drawable.ic_forward),
            contentDescription = "Google",
            modifier = modifier.padding(horizontal = 8.dp))
    }
}