package com.example.chatapplication.di

import com.example.chatapplication.data.datasource.AuthOnlineDataSourceImpl
import com.example.chatapplication.data.repository.AuthRrpositoryimpl
import com.example.chatapplication.domain.repository.AuthOnlineDataSource
import com.example.chatapplication.domain.repository.AuthRepository
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun ProvideFirebaseAuth(): FirebaseAuth {
        return Firebase.auth
    }

    @Provides
    @Singleton
    fun ProvideAuthOnlineDataSource(auth: FirebaseAuth): AuthOnlineDataSource {
        return AuthOnlineDataSourceImpl(auth)
    }

    @Provides
    @Singleton
    fun ProvideAuthRepository(authOnlineDataSource: AuthOnlineDataSource): AuthRepository {
        return AuthRrpositoryimpl(authOnlineDataSource)
    }

}