package com.example.fintech.di

import com.example.fintech.common.Constants
import com.example.fintech.data.remote.CoinJsonApi
import com.example.fintech.data.remote.CoinPaprikaApi
import com.example.fintech.data.repository.CoinRepositoryImpl
import com.example.fintech.data.repository.GeckoRepositoryImpl
import com.example.fintech.domain.repository.CoinRepository
import com.example.fintech.domain.repository.JsonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
private const val BASE_URL_JSON = "http://api.coinlayer.com/"
@Module
@InstallIn(SingletonComponent::class)
object AppModule_ {
    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }

    @Singleton
    fun provideCryptoApi(): CoinJsonApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_JSON)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinJsonApi::class.java)
    }

    @Singleton
    fun provideJsonRepository(api: CoinJsonApi): JsonRepository {
        return GeckoRepositoryImpl(api)
    }
}