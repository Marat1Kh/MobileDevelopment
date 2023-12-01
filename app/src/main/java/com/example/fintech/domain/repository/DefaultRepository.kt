package com.example.fintech.domain.repository

import com.example.fintech.common.Resource
import com.example.fintech.data.remote.CoinJsonApi
import com.example.fintech.domain.model.CryptoResponse
import javax.inject.Inject

class DefaultRepository(private val api: CoinJsonApi): JsonRepository
{
    override suspend  fun getRates(target: String): Resource<CryptoResponse> {
        return try{
            val response = api.getRates(target)
            val result = response.data
            if(result != null){
                Resource.Success(result)
            } else{
                Resource.Error("error")
            }
        } catch (e: Exception){
            Resource.Error(e.message?: "An error occurred")
        }
    }
}