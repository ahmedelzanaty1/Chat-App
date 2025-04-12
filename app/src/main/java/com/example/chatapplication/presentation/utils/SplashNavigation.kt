package com.example.chatapplication.presentation.utils

 sealed interface SplashNavigation {
     data object Home : SplashNavigation
     data object Login : SplashNavigation
     data object Idle : SplashNavigation

}