package com.example.fintech.domain.repository

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fintech.data.remote.CryptoApi
import com.example.fintech.domain.model.CryptoModel
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ChartViewModel : ViewModel() {
    private val _cryptoModels = mutableStateOf<List<CryptoModel>>(listOf())
    val cryptoModels: State<List<CryptoModel>> = _cryptoModels
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CryptoApi::class.java)

    init {
        fetchCryptoData()
    }

    private fun fetchCryptoData() {
        viewModelScope.launch {
                val fetchedData = listOf<CryptoModel>() // Example data
                _cryptoModels.value = fetchedData
            }
        }
    }
