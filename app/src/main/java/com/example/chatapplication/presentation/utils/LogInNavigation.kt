package com.example.chatapplication.presentation.utils

sealed interface LogInNavigation {
  data  object Idle : LogInNavigation
  data  object Home : LogInNavigation
   data object NavigationUp : LogInNavigation

}