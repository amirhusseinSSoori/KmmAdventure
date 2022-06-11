package com.amirhusseinsoori.kmmadventure.repository

import arrow.core.Either
import com.amirhusseinsoori.kmmadventure.Const.POST
import com.amirhusseinsoori.kmmadventure.response.UserResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class UserRepositoryImp(private val apiService: HttpClient) : UserRepository {
    override suspend fun getProducts(): Flow<Either<List<UserResponse>, Throwable>> =
        flow<Either<List<UserResponse>, Throwable>> {
            emit(Either.Left(apiService.get { url(POST) }.body()))
        }.catch { ex ->
            emit(Either.Right(ex))
        }
}



