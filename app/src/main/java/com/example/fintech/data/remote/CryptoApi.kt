package com.example.fintech.data.remote

import com.example.fintech.domain.model.CryptoModel
import retrofit2.Call
import retrofit2.http.GET

interface CryptoApi {
    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
    fun getData(): Call<List<CryptoModel>>
}