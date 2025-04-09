package com.example.chatapplication.data.datasource

import com.example.chatapplication.domain.entity.AppUser
import com.example.chatapplication.domain.repository.AuthOnlineDataSource
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await

class AuthOnlineDataSourceImpl (
    private val auth: FirebaseAuth
): AuthOnlineDataSource {
    override suspend fun login(
        email: String,
        password: String,
        onSuccess: (userid: String) -> Unit,
        onError: (t: Throwable) -> Unit
    ) {
        try {
            val result = auth.signInWithEmailAndPassword(email, password).await()
            if (result.user != null) {
                onSuccess(result.user!!.uid)
            }else{
                onError(Throwable("User is null"))
            }
        }catch (e : Exception){
            onError(e)
        }
    }

    override suspend fun register(
        user: AppUser,
        password: String,
        onSuccess: (userid: String) -> Unit,
        onError: (t: Throwable) -> Unit
    ) {
        try {
            val result = auth.createUserWithEmailAndPassword(user.email, password).await()
            if (result.user != null) {
                onSuccess(result.user!!.uid)
            }else{
                onError(Throwable("User is null"))
            }
        }catch (e : Exception){
            onError(e)

            }
    }
}