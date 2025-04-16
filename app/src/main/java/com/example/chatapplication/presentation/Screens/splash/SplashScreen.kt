package com.example.chatapplication.presentation.Screens.splash

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.chatapplication.R
import com.example.chatapplication.presentation.ViewModel.SplashViewModel
import com.example.chatapplication.presentation.utils.SplashNavigation
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun SplashScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: SplashViewModel = hiltViewModel()
) {
    val navigationState = viewModel.navigation.value

    LaunchedEffect(navigationState) {
        when (navigationState) {
            is SplashNavigation.Home -> {
                Log.d("SplashScreen", "Navigating to Home")
                navController.navigate("home") {
                    popUpTo("splash") { inclusive = true }
                }
            }

            is SplashNavigation.Login -> {
                Log.d("SplashScreen", "Navigating to Login")
                navController.navigate("sign_in") {
                    popUpTo("splash") { inclusive = true }
                }
            }

            else -> {
                Log.d("SplashScreen", "Still in Idle state")
            }
        }
    }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.size(200.dp),
            contentScale = ContentScale.Crop
        )
    }
}


