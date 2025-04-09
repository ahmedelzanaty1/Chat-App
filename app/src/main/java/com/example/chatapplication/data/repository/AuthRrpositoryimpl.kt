package com.example.chatapplication.data.repository

import com.example.chatapplication.domain.entity.AppUser
import com.example.chatapplication.domain.repository.AuthOnlineDataSource
import com.example.chatapplication.domain.repository.AuthRepository

class AuthRrpositoryimpl(
    private val authOnlineDataSource: AuthOnlineDataSource
) : AuthRepository {
    override suspend fun login(
        email: String,
        password: String,
        onSuccess: (userid: String) -> Unit,
        onError: (t: Throwable) -> Unit
    ) {
        authOnlineDataSource.login(email, password, onSuccess, onError)
    }

    override suspend fun register(
        user: AppUser,
        password: String,
        onSuccess: (userid: String) -> Unit,
        onError: (t: Throwable) -> Unit
    ) {
        authOnlineDataSource.register(user, password, onSuccess, onError)

    }
}