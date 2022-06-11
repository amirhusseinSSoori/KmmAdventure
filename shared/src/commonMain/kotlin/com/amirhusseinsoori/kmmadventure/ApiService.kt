package com.amirhusseinsoori.kmmadventure

import io.ktor.client.*

expect class ApiService{
    fun build(): HttpClient
}