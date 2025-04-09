package com.example.chatapplication.presentation.ViewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    val emailState = mutableStateOf("")
    val emailerrorState = mutableStateOf("")
    val passwordState = mutableStateOf("")
    val passworderrorState = mutableStateOf("")

    fun ValidateLogin(): Boolean {
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
            return true
        }

    }
    fun register() {
        if (ValidateLogin()) {
            //TODO
        }
    }


}