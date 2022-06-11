package com.amirhusseinsoori.kmmadventure.android

import com.amirhusseinsoori.kmmadventure.response.UserResponse

data class MainState (
    val list: List<UserResponse> = emptyList(),
    val message: String = "",
    val isLoading: Boolean = false
)