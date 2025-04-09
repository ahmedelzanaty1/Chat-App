package com.example.chatapplication.domain.repository

import com.example.chatapplication.domain.entity.AppUser

interface AuthRepository {
    suspend fun login(email: String, password: String ,
                      onSuccess: (userid: String) -> Unit
                      , onError: (t : Throwable) -> Unit)

    suspend fun register(user : AppUser,password: String ,
                         onSuccess: (userid: String) -> Unit
                         , onError: (t : Throwable) -> Unit
    )
}

interface AuthOnlineDataSource{
    suspend fun login(email: String, password: String ,
                      onSuccess: (userid: String) -> Unit
                      , onError: (t : Throwable) -> Unit)


    suspend fun register(user : AppUser,password: String ,
                         onSuccess: (userid: String) -> Unit
                         , onError: (t : Throwable) -> Unit
    )

}