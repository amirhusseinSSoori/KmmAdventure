package com.amirhusseinsoori.kmmadventure.response

import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)