package com.example.fintech.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class CryptoConversion(
    val isLoading: Boolean = false,
    val coin: String = "",
    val error: String = ""
)
