package com.example.fintech.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class CryptoModel(
    var currency: String,
    var price: String
)