package com.example.fintech.di
import com.example.fintech.data.remote.CoinJsonApi
import com.example.fintech.domain.repository.DefaultRepository
import com.example.fintech.domain.repository.JsonRepository
import com.example.fintech.domain.repository.JsonViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
private const val BASE_URL = "http://api.coinlayer.com/"
val appModule = module {
    fun provideCryptoApi(): CoinJsonApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CoinJsonApi::class.java)

    fun provideMainRepository(api: CoinJsonApi): JsonRepository = DefaultRepository(api)

    single { provideCryptoApi() }
    single { provideMainRepository(get()) }
    viewModel { JsonViewModel(get()) }
}