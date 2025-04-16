package com.example.chatapplication.presentation.ViewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatapplication.constants.Destinations
import com.example.chatapplication.domain.entity.AppUser
import com.example.chatapplication.domain.use.AddUserUseCase
import com.example.chatapplication.domain.use.RegisterUseCase
import com.example.chatapplication.presentation.base.BaseViewModel
import com.example.chatapplication.presentation.utils.RegisterNavigation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase,
    private val adduser : AddUserUseCase
) : BaseViewModel() {

    val emailState = mutableStateOf("")
    val emailerrorState = mutableStateOf("")
    val passwordState = mutableStateOf("")
    val passworderrorState = mutableStateOf("")
    val usernameState = mutableStateOf("")
    val usernameerrorState = mutableStateOf("")
    val navigation = mutableStateOf<RegisterNavigation>(RegisterNavigation.Idle)


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
               showLoading()
               viewModelScope.launch {
                   try {
                       val user = AppUser(fullName = usernameState.value, email = emailState.value)
                       val result =
                           registerUseCase(user, passwordState.value, onSuccess = { uid: String ->
                               val newuser = user.let {
                                   AppUser(it.fullName, it.email, uid)
                               }
                               launch {
                                   adduser(newuser, onSuccess = {
                                       hideLoading()
                                       navigation.value = RegisterNavigation.Home

                                   }, onError = {
                                       hideLoading()
                                       showError(it.message.toString())
                                   })
                               }

                           }, onError = {
                               hideLoading()
                               showError(it.message.toString())
                           })


                   } catch (e: Exception) {
                       hideLoading()
                       showError(e.message.toString())
                   }

               }
           }
       }
    fun navigateUp() {
        navigation.value = RegisterNavigation.NavigationUp
    }

    }

