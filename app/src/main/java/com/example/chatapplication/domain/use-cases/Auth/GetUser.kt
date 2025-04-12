package com.example.chatapplication.domain.use

import com.example.chatapplication.domain.entity.AppUser
import com.example.chatapplication.domain.repository.AuthRepository
import javax.inject.Inject


class GetUser @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        uid: String,
        onSuccess: (AppUser) -> Unit,
        onError: (t: Throwable) -> Unit
    ) {
        authRepository.getUser(uid, onSuccess, onError)

    }
}