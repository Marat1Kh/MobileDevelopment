package com.example.fintech.domain.repository

import com.example.fintech.common.Resource
import com.example.fintech.domain.model.CryptoResponse

interface JsonRepository{
    suspend fun getRates(target: String): Resource<CryptoResponse>
}