package com.example.chatapplication.domain.repository

import com.example.chatapplication.domain.entity.Room

 interface ChatRepository {
    suspend fun createRoom(room: Room , onSuccess : () -> Unit , onError : (throwable : Throwable) -> Unit)
    suspend fun listenerRoom(onSuccess : (room : List<Room>) -> Unit ,
                             onError : (throwable : Throwable) -> Unit)
}

 interface ChatOnlineDataSource{
    suspend fun createRoom(room: Room , onSuccess : () -> Unit , onError : (throwable : Throwable) -> Unit)
     suspend fun listenerRoom(onSuccess : (room : List<Room>) -> Unit ,
                              onError : (throwable : Throwable) -> Unit)

}