package com.example.chatapplication.presentation.utils

sealed interface RegisterNavigation {
   data object Home : RegisterNavigation
  data  object Idle : RegisterNavigation
    data object NavigationUp : RegisterNavigation


}