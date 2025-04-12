package com.example.chatapplication.domain.entity

data class AppUser(
    val userid: String = "",
    val email : String = "",
    val fullName : String = ""
){
    companion object{
        const val COLLECTION_NAME = "users"
    }
}
