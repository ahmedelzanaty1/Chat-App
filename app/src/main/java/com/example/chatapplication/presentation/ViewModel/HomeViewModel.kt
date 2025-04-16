package com.example.chatapplication.presentation.ViewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.chatapplication.domain.entity.Room
import com.example.chatapplication.domain.use.ListenerRoomUseCse
import com.example.chatapplication.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val authUseCase: ListenerRoomUseCse
): BaseViewModel() {
    val roomliststate = mutableStateListOf<Room>()
    val userId: String = "currentUserId"

    fun listenerRoom() {
        viewModelScope.launch {
            showLoading()
            authUseCase(
                onSuccess = {
                    roomliststate.clear()
                    val userRooms = it.filter { room -> room.userId == userId }
                    roomliststate.addAll(userRooms)
                    hideLoading()
                },
                onError = {
                    hideLoading()
                    showError(it.toString())
                }
            )
        }
    }
}
