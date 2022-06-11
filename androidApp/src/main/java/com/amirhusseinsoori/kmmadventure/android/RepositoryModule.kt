package com.amirhusseinsoori.kmmadventure.android

import com.amirhusseinsoori.kmmadventure.ApiService
import com.amirhusseinsoori.kmmadventure.repository.UserRepository

import com.amirhusseinsoori.kmmadventure.repository.UserRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    @Singleton
    @Provides
    fun provideApiService(): HttpClient {
        return ApiService().build()
    }


    @Provides
    fun provideFetchMovieDetail(api: HttpClient): UserRepository {
        return UserRepositoryImp(api)
    }

}
