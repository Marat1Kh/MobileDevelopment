package com.example.fintech.domain.model

import kotlinx.serialization.Serializable

/**
 * Coin price
 *
 * @property close
 * @property high
 * @property low
 * @property market_cap
 * @property open
 * @property time_close
 * @property time_open
 * @property volume
 * @constructor Coin prices
 */
@Serializable
data class CoinPrice(
    val close: Double,
    val high: Double,
    val low: Double,
    val market_cap: Long,
    val `open`: Double,
    val time_close: String,
    val time_open: String,
    val volume: Int
)