package com.example.chatapplication.domain.use

import com.example.chatapplication.domain.repository.AuthRepository
import javax.inject.Inject


class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        email: String,
        password: String,
        onSuccess: (userid: String) -> Unit,
        onError: (t: Throwable) -> Unit){
        authRepository.login(email, password, onSuccess, onError)

    }
}