package com.example.fintech.domain.repository

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.fintech.domain.model.CryptoConversion
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import com.example.fintech.common.Resource
import com.example.fintech.domain.model.CryptoRates
import kotlinx.coroutines.launch
import java.math.RoundingMode
import java.text.DecimalFormat

class JsonViewModel(private val repository: JsonRepository): ViewModel() {
    private val _conversion = mutableStateOf(CryptoConversion())
    val conversion: State<CryptoConversion> = _conversion

    fun convert(amount: String, fromCurrency: String, toCurrency: String) {
        val fromAmount = amount.toFloatOrNull()
        if (fromAmount == null) {
            _conversion.value = CryptoConversion(error = "Invalid amount supplied")
        }
        viewModelScope.launch {
            when (val ratesResponse = repository.getRates(fromCurrency)) {
                is Resource.Error -> {
                    _conversion.value = CryptoConversion(error = ratesResponse.message!!)
                }

                is Resource.Success -> {
                    val rates = ratesResponse.data!!.rates
                    val rate = getRateFromCrypto(toCurrency, rates)
                    if (rate == null) {
                        _conversion.value = CryptoConversion(error = "Unexpected error")
                    } else {
                        val df = DecimalFormat("#.####")
                        df.roundingMode = RoundingMode.CEILING
                        val convertedCurrency = df.format(fromAmount!! / rate)
                        _conversion.value = CryptoConversion(coin = "$convertedCurrency $toCurrency")
                    }
                }

            }
        }
    }
        private fun getRateFromCrypto(toCurrency: String, rates: CryptoRates) = when (toCurrency) {
            "ADA" -> rates.ADA
            "BCD" -> rates.BCD
            "BCH" -> rates.BCH
            "BNB" -> rates.BNB
            "BTC" -> rates.BTC
            "BTCA" -> rates.BTCA
            "DOGE" -> rates.DOGE
            "DRGN" -> rates.DRGN
            "EOS" -> rates.EOS
            "ERT" -> rates.ERT
            "ETC" -> rates.ETC
            "ETH" -> rates.ETH
            "LEO" -> rates.LEO
            "LINDA" -> rates.LINDA
            "LINK" -> rates.LINK
            "LTC" -> rates.LTC
            "LUN" -> rates.LUN
            "MANA" -> rates.MANA
            "MIOTA" -> rates.MIOTA
            "TESLA" -> rates.TESLA
            "THC" -> rates.THC
            "THETA" -> rates.THETA
            "THS" -> rates.THS
            "TRUMP" -> rates.TRUMP
            "TRX" -> rates.TRX
            "USDT" -> rates.USDT
            "WAVES" -> rates.WAVES
            "WAX" -> rates.WAX
            "WTC" -> rates.WTC
            "XLM" -> rates.XLM
            "XTZ" -> rates.XTZ
            "XMR" -> rates.XMR
            "XRP" -> rates.XRP
            else -> null
        }
}
