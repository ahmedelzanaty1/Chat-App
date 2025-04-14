package com.example.chatapplication.di

import com.example.chatapplication.data.datasource.AuthOnlineDataSourceImpl
import com.example.chatapplication.data.datasource.ChatOnlineDataImpl
import com.example.chatapplication.data.repository.AuthRrpositoryimpl
import com.example.chatapplication.data.repository.ChatRepositoryImpl
import com.example.chatapplication.domain.repository.AuthOnlineDataSource
import com.example.chatapplication.domain.repository.AuthRepository
import com.example.chatapplication.domain.repository.ChatOnlineDataSource
import com.example.chatapplication.domain.repository.ChatRepository
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
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
    fun providefirebaseStore(): FirebaseFirestore {
        return Firebase.firestore
    }


    @Provides
    @Singleton
    fun ProvideAuthOnlineDataSource(auth: FirebaseAuth , firestore: FirebaseFirestore): AuthOnlineDataSource {
        return AuthOnlineDataSourceImpl(auth , firestore)
    }

    @Provides
    @Singleton
    fun ProvideAuthRepository(authOnlineDataSource: AuthOnlineDataSource): AuthRepository {
        return AuthRrpositoryimpl(authOnlineDataSource)
    }
    @Provides
    @Singleton
    fun ProvideChatOnlineDataSource(firestore: FirebaseFirestore): ChatOnlineDataSource {
        return ChatOnlineDataImpl(firestore)
    }
    @Provides
    @Singleton
    fun ProvideChatRepository(chatOnlineDataSource: ChatOnlineDataSource): ChatRepository {
        return ChatRepositoryImpl(chatOnlineDataSource)
    }


}