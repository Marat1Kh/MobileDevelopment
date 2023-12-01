package com.example.fintech.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class CryptoResponse(
    val timestamp: Int,
    val target: String,
    val rates: CryptoRates
)
