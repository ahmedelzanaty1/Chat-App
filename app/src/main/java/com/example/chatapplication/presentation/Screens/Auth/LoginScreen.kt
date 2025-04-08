package com.example.chatapplication.presentation.Screens.Auth


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextPainter.paint
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.chatapplication.R
import com.example.chatapplication.presentation.componant.TopBar

@Composable
fun LoginScreen(modifier: Modifier = Modifier , navController:NavController) {
    Scaffold(
        topBar = { TopBar(title = "Login") }
    ) { innerPadding ->
        innerPadding
        Column(
            modifier = modifier.fillMaxSize()
                .paint(
                    painter = painterResource(id = R.drawable.background1),
                    contentScale = ContentScale.Crop
                )
        ) {

        }
    }
}

