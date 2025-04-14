package com.example.chatapplication.domain.use

import com.example.chatapplication.domain.entity.Room
import com.example.chatapplication.domain.repository.ChatRepository
import javax.inject.Inject


class AddRoomUseCse @Inject constructor(
    private val repository: ChatRepository
){
    suspend operator fun invoke(room: Room ,
                                onSuccess : () -> Unit ,
                                onError : (throwable : Throwable) -> Unit){
        repository.createRoom(room , onSuccess , onError)
    }

}