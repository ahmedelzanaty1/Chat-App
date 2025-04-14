package com.example.chatapplication.domain.entity

data class Room(
    var id: String = "",
    val name: String = "",
    val description: String = "",
    val categoryName: String = "",
    val categoryId: String = ""
){
    companion object{
        const val COLLECTION_NAME = "rooms"
    }
}
