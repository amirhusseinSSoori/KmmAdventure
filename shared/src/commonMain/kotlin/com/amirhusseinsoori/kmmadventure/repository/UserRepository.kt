package com.amirhusseinsoori.kmmadventure.repository

import arrow.core.Either
import com.amirhusseinsoori.kmmadventure.response.UserResponse
import kotlinx.coroutines.flow.Flow

interface UserRepository
{ suspend fun getProducts(): Flow<Either<List<UserResponse>,Throwable>>
}