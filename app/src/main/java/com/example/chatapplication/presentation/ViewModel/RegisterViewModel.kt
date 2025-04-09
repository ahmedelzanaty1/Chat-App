package com.example.chatapplication.presentation.ViewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class RegisterViewModel @Inject constructor() : ViewModel() {

    val emailState = mutableStateOf("")
    val emailerrorState = mutableStateOf("")
    val passwordState = mutableStateOf("")
    val passworderrorState = mutableStateOf("")
    val usernameState = mutableStateOf("")
    val usernameerrorState = mutableStateOf("")


    fun Validate(): Boolean {
        if (emailState.value.isEmpty()) {
            emailerrorState.value = "Email is required"
            return false
        } else {
            emailerrorState.value = ""
        }
        if (passwordState.value.isEmpty()) {
            passworderrorState.value = "Password is required"
            return false
        } else {
            passworderrorState.value = ""
        }
        if (usernameState.value.isEmpty()) {
            usernameerrorState.value = "Username is required"
            return false
        } else {
            usernameerrorState.value = ""
            return true
        }

    }
    fun register() {
        if (Validate()) {
            //TODO
        }
    }
    }

