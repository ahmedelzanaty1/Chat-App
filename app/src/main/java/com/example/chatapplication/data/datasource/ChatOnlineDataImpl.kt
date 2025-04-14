package com.example.chatapplication.data.datasource

import com.example.chatapplication.domain.entity.Room
import com.example.chatapplication.domain.repository.ChatOnlineDataSource
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class ChatOnlineDataImpl(
    private val firestore: FirebaseFirestore
) : ChatOnlineDataSource {
    override suspend fun createRoom(
        room: Room,
        onSuccess: () -> Unit,
        onError: (throwable: Throwable) -> Unit
    ) {
        try {


            val documentRef = firestore.collection(Room.COLLECTION_NAME).document()
            room.id = documentRef.id
          val result =   documentRef.set(room).await()
            onSuccess.invoke()

        }catch (e : Exception){
            onError.invoke(e)

        }
    }
}