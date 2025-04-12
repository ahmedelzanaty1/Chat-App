package com.example.chatapplication.presentation.ViewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatapplication.domain.use.GetUser
import com.example.chatapplication.domain.use.LoginUseCase
import com.example.chatapplication.presentation.base.BaseViewModel
import com.example.chatapplication.presentation.utils.LogInNavigation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val getUserNameUseCase: GetUser
) : BaseViewModel() {

    val emailState = mutableStateOf("")
    val emailerrorState = mutableStateOf("")
    val passwordState = mutableStateOf("")
    val passworderrorState = mutableStateOf("")
    val navigation = mutableStateOf<LogInNavigation>(LogInNavigation.Idle)


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
    fun login() {
        if (ValidateLogin()) {
            showLoading()
            viewModelScope.launch {
                try{
                    val result = loginUseCase(emailState.value, passwordState.value ,
                        onSuccess = {uid : String ->
                            hideLoading()
                            launch {
                                getUserNameUseCase(uid ,
                                    onSuccess = {
                                        navigation.value = LogInNavigation.Home
                                        hideLoading()

                                    } ,
                                    onError = {
                                        hideLoading()
                                        showError(it.message.toString())
                                    })
                            }

                        }, onError = {
                            hideLoading()
                            showError(it.message.toString())
                        })
                }catch (e : Exception){
                    hideLoading()
                    showError(e.message.toString())

                }
            }
        }
    }
    fun navigatetoRegister(){
        navigation.value = LogInNavigation.NavigationUp

    }


}