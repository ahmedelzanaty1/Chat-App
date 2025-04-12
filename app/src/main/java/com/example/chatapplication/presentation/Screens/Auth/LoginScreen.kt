package com.example.chatapplication.presentation.Screens.Auth


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextPainter.paint
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.chatapplication.R
import com.example.chatapplication.presentation.ViewModel.LoginViewModel
import com.example.chatapplication.presentation.base.BaseComposable
import com.example.chatapplication.presentation.componant.AuthButtons
import com.example.chatapplication.presentation.componant.ChatAuthTextField
import com.example.chatapplication.presentation.componant.TopBar

@Composable
fun LoginScreen(modifier: Modifier = Modifier , navController:NavController) {
    BaseComposable<LoginViewModel> {viewModel ->
        Scaffold(
            topBar = { TopBar(title = "Login") }
        ) { innerPadding ->
            Column(
                modifier = modifier.fillMaxSize().padding(innerPadding)
                    .paint(
                        painter = painterResource(id = R.drawable.background1),
                        contentScale = ContentScale.Crop
                    ), horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.fillMaxHeight(.4F))
                Text(
                    text = "Welcome Back! ", fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black, modifier = modifier.align(Alignment.Start)
                        .padding(12.dp)
                )
                Spacer(modifier = Modifier.padding(10.dp))
                ChatAuthTextField(
                    modifier,
                    state = viewModel.emailState,
                    error = viewModel.emailerrorState.value,
                    label = "Email"
                )
                Spacer(modifier = Modifier.height(10.dp))
                ChatAuthTextField(
                    modifier,
                    state = viewModel.passwordState,
                    error = viewModel.passworderrorState.value,
                    label = "Password"
                )
                Spacer(modifier = Modifier.padding(10.dp))
                AuthButtons("Login", onClick = {
                    viewModel.login()
                })
                Spacer(modifier = Modifier.padding(10.dp))
                Text(text = "or create account",
                    color = Color.Black,
                    modifier = modifier.align(Alignment.CenterHorizontally)
                        .clickable {
                            navController.navigate("sign_up") {

                            }

                        })

            }
        }
    }
}
