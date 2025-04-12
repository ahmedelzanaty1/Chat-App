package com.example.chatapplication.presentation.base

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    val loadingState = mutableStateOf(false)
    val dialogState = mutableStateOf("")

    fun showLoading(){
        loadingState.value = true
    }
    fun hideLoading(){
        loadingState.value = false
    }
    fun showError(message : String){
        dialogState.value = message
    }
    fun hideError(){
        dialogState.value = ""
    }
    }
