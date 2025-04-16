package com.example.chatapplication.presentation.ViewModel

import android.util.Log
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
    val navigation = mutableStateOf<SplashNavigation>(SplashNavigation.Idle)
    init {
        viewModelScope.launch {
            delay(1500)
            val auth = Firebase.auth
            val uid = auth.currentUser?.uid
            if (uid != null) {
                getuser(uid,
                    onSuccess = {
                        Log.d("SplashVM", "User found, going to Home")
                        navigation.value = SplashNavigation.Home
                    },
                    onError = {
                        Log.d("SplashVM", "Error getting user, going to Login")
                        navigation.value = SplashNavigation.Login
                    }
                )
            } else {
                Log.d("SplashVM", "No UID, going to Login")
                navigation.value = SplashNavigation.Login
            }
        }

    }
}