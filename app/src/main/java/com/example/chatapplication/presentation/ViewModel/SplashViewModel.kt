package com.example.chatapplication.presentation.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatapplication.domain.use.GetUser
import com.example.chatapplication.presentation.utils.SplashNavigation
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getuser : GetUser
) : ViewModel(){
    var isSplashFinish by mutableStateOf(false)
        private set
    val navigation = mutableStateOf<SplashNavigation>(SplashNavigation.Idle)
    init {
        viewModelScope.launch {
            delay(3000)
            val auth = Firebase.auth
            auth.currentUser?.uid.let {
                getuser(it!! ,
                    onSuccess = {
                        navigation.value = SplashNavigation.Home
                    }, onError = {
                        navigation.value = SplashNavigation.Login
                    })

            }
            isSplashFinish = true
        }
    }
}