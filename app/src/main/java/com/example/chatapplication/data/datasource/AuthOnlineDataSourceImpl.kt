package com.example.chatapplication.data.datasource

import com.example.chatapplication.domain.entity.AppUser
import com.example.chatapplication.domain.repository.AuthOnlineDataSource
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class AuthOnlineDataSourceImpl (
    private val auth: FirebaseAuth,
    private val firestore: FirebaseFirestore
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

    override suspend fun addUser(
        appUser: AppUser,
        onSuccess: () -> Unit,
        onError: (t: Throwable) -> Unit
    ) {
        try {
            val result = firestore.collection(AppUser.COLLECTION_NAME).document(appUser.userid)
                .set(appUser).await()
            onSuccess()
        }catch (e : Exception){
            onError(e)

        }
    }

    override suspend fun getUser(
        uid: String,
        onSuccess: (AppUser) -> Unit,
        onError: (t: Throwable) -> Unit
    ) {
        try {
            val result = firestore.collection(AppUser.COLLECTION_NAME).document(uid)
                .get().await()
            val appUser = result.toObject(AppUser::class.java)
            if (appUser != null) {
                onSuccess(appUser)
            }else{
                onError(Throwable("User is null"))
            }
        }catch (e : Exception){
            onError(e)
        }

    }
}