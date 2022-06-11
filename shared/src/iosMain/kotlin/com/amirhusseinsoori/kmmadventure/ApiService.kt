package com.amirhusseinsoori.kmmadventure

import io.ktor.client.*
import io.ktor.client.engine.ios.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*

actual class ApiService {
    actual fun build(): HttpClient {
        return HttpClient(Ios) {
            install(Logging) {
                level = LogLevel.ALL
            }
            // JSON
            install(ContentNegotiation) {
                json()
            }
            // Timeout
            install(HttpTimeout) {
                requestTimeoutMillis = 15000L
                connectTimeoutMillis = 15000L
                socketTimeoutMillis = 15000L
            }
            // Apply to all requests
            defaultRequest {
                // Parameter("api_key", "some_api_key")
                // Content Type
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
            }
        }
    }
}