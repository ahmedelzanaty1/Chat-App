package com.example.chatapplication.data.repository

import com.example.chatapplication.domain.entity.Room
import com.example.chatapplication.domain.repository.ChatOnlineDataSource
import com.example.chatapplication.domain.repository.ChatRepository

class ChatRepositoryImpl(
    private val chatOnlineDataSource: ChatOnlineDataSource
) : ChatRepository {
    override suspend fun createRoom(
        room: Room,
        onSuccess: () -> Unit,
        onError: (throwable: Throwable) -> Unit
    ) {
        chatOnlineDataSource.createRoom(room, onSuccess, onError)

    }
}