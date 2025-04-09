package com.example.chatapplication.domain.use

import com.example.chatapplication.domain.entity.AppUser
import com.example.chatapplication.domain.repository.AuthRepository
import javax.inject.Inject


class RegisterUseCase @Inject constructor(
    private val authRepository: AuthRepository

) {
    suspend operator fun invoke(
        user: AppUser,
        password: String,
        onSuccess: (userid: String) -> Unit,
        onError: (t: Throwable) -> Unit){
        authRepository.register(user, password, onSuccess, onError)
    }
}