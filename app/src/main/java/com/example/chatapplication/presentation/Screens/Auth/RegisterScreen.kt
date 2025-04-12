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
import com.example.chatapplication.constants.Destinations
import com.example.chatapplication.presentation.ViewModel.LoginViewModel
import com.example.chatapplication.presentation.ViewModel.RegisterViewModel
import com.example.chatapplication.presentation.base.BaseComposable
import com.example.chatapplication.presentation.componant.AuthButtons
import com.example.chatapplication.presentation.componant.ChatAuthTextField
import com.example.chatapplication.presentation.componant.TopBar
import com.example.chatapplication.presentation.utils.RegisterNavigation

@Composable
fun RegisterScreen(modifier: Modifier = Modifier , navController:NavController ,
                   viewModel: RegisterViewModel = hiltViewModel()) {
    BaseComposable<RegisterViewModel> {
        Scaffold(
            topBar = { TopBar(title = "Register", hasButtonBack = true){
                viewModel.navigateUp()
            } }
        ) { innerPadding ->
            innerPadding
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .paint(
                        painter = painterResource(id = R.drawable.background1),
                        contentScale = ContentScale.Crop
                    ), horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.fillMaxHeight(.4F))
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
                    state = viewModel.usernameState,
                    error = viewModel.usernameerrorState.value,
                    label = "Username"
                )
                Spacer(modifier = Modifier.height(10.dp))
                ChatAuthTextField(
                    modifier,
                    state = viewModel.passwordState,
                    error = viewModel.passworderrorState.value,
                    label = "Password"
                )
                Spacer(modifier = Modifier.padding(10.dp))
                AuthButtons("Sign up", onClick = {
                    viewModel.register()
                })

            }
            when (viewModel.navigation.value) {
                RegisterNavigation.Home -> {
                    navController.clearBackStack(Destinations.SIGN_IN)
                    navController.navigate(Destinations.HOME){
                        popUpTo(Destinations.SIGN_IN){
                            inclusive = true
                        }
                    }
                    viewModel.navigation.value = RegisterNavigation.Idle
                }
                RegisterNavigation.Idle -> {}
                RegisterNavigation.NavigationUp -> {
                    navController.navigateUp()
                }
            }
        }
    }

}