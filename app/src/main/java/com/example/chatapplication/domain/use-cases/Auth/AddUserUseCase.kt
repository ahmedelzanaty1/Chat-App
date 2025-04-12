package com.example.chatapplication.domain.use

import com.example.chatapplication.domain.entity.AppUser
import com.example.chatapplication.domain.repository.AuthRepository
import javax.inject.Inject


class AddUserUseCase @Inject constructor(
    private val authRepository: AuthRepository
){
    suspend operator fun invoke(
        appUser: AppUser,
        onSuccess: () -> Unit,
        onError: (t: Throwable) -> Unit
    ) {
        authRepository.addUser(appUser, onSuccess, onError)

    }
}