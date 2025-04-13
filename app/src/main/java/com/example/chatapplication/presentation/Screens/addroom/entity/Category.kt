package com.example.chatapplication.presentation.Screens.addroom.entity

import com.example.chatapplication.R

data class Category(
    val roomId : String = "" ,
    val roomName : String = "" ,
    val roomImage : Int = 0
){
    companion object{
        const val MUSIC = "MUSIC"
        const val MOVIES = "MOVIES"
        const val SPORTS = "SPORTS"

        fun getCategories(): List<Category>{
            return listOf(
                fromId(MUSIC),
                fromId(MOVIES),
                fromId(SPORTS)
            )
        }

        fun fromId(id : String) : Category {
            return when(id){
                MUSIC -> Category(id , "Music", roomImage = R.drawable.music)
                MOVIES -> Category(id , "Movies", roomImage = R.drawable.movie)
                SPORTS -> Category(id , "Sports", roomImage = R.drawable.sport)
                else -> throw IllegalArgumentException("Invalid category id")
            }
        }
    }
}
