package com.example.fintech.data.repository

import com.example.fintech.common.Resource
import com.example.fintech.data.remote.CoinJsonApi
import com.example.fintech.domain.model.CryptoResponse
import com.example.fintech.domain.repository.JsonRepository
import retrofit2.Response
import retrofit2.http.Query
import javax.inject.Inject

class GeckoRepositoryImpl @Inject constructor(
    private val api: CoinJsonApi
): JsonRepository{
    override suspend fun getRates(target: String): Resource<CryptoResponse> {
       return api.getRates(target)
    }

}