package com.example.fintech.domain.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

/**
 * Coin
 *
 * @property id
 * @property isActive
 * @property name
 * @property rank
 * @property symbol
 * @property price
 * @constructor Coin info
 */
@Serializable
data class Coin(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    @SerializedName("price")
    val price: Double
)
