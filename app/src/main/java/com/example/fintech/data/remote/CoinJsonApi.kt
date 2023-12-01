package com.example.fintech.data.remote

import com.example.fintech.common.Resource
import com.example.fintech.domain.model.CryptoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinJsonApi {
//    @GET("/live?access_key=dce41459f13f0414a49181142defe018")
    @GET("/live?access_key=dce0443da64173ad0e79900000528f8e10")
    suspend fun getRates(@Query("target") target: String): Resource<CryptoResponse>
}