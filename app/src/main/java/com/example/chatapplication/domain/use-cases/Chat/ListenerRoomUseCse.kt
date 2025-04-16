package com.example.chatapplication.domain.use

import com.example.chatapplication.domain.entity.Room
import com.example.chatapplication.domain.repository.ChatRepository
import javax.inject.Inject


class ListenerRoomUseCse @Inject constructor(
    private val repository: ChatRepository
){
    suspend operator fun invoke(
        onSuccess: (room: List<Room>) -> Unit,
        onError: (throwable: Throwable) -> Unit
    ) {
        repository.listenerRoom(onSuccess, onError)
    }
}