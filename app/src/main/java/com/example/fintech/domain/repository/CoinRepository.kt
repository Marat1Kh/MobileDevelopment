package com.example.fintech.domain.repository

import com.example.fintech.data.remote.dto.CoinDetailDto
import com.example.fintech.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto

}