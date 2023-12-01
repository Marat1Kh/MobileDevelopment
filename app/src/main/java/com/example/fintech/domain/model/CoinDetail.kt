package com.example.fintech.domain.model

import com.example.fintech.data.remote.dto.TeamMember
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

/**
 * Coin detail
 *
 * @property coinId
 * @property name
 * @property description
 * @property symbol
 * @property rank
 * @property isActive
 * @property tags
 * @property team
 * @property price
 * @constructor Coin details
 */
@Serializable
data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>,
    val price: Double
)
