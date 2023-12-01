package com.example.fintech

import com.example.fintech.data.remote.CryptoApi
import com.example.fintech.domain.model.CryptoModel
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.junit.Test
import org.mockito.Mockito
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import retrofit2.Call
import retrofit2.Response
import java.io.File
import kotlin.random.Random

class CryptoApiTest {
    private fun loadCryptoList(): List<CryptoModel>{
        val jsonFile = File("/Users/makok/Downloads/Fintech 3/app/src/test/java/com/example/fintech/data.json")
        val jsonContent = jsonFile.readText()
        val mapper = jacksonObjectMapper()
        return mapper.readValue(jsonContent)
    }
    @Test
    fun `1000 API calls and filter crypto`() {
        val cryptoList = loadCryptoList()
        repeat(1000){
            val expensiveCoins = cryptoList.filter{
                val price = it.price.toDoubleOrNull() ?: 0.0
                price > 100.0
            }
            assert(expensiveCoins.isNotEmpty())
        }
        val lastExpensiveCoins = cryptoList.filter{
            val price = it.price.toDoubleOrNull() ?: 0.0
            price > 100
        }
        lastExpensiveCoins.forEach{ coin ->
            println("Coin: ${coin.currency}, Price: ${coin.price}")
        }
}
    @Test
    fun `filter cryptos above random price threshold`() {
        val cryptoList = loadCryptoList()
        val randomThreshold = Random.nextDouble(0.1, 0.5)
        val filteredList = cryptoList.filter { it.price.toDouble() > randomThreshold }
        filteredList.forEach { crypto ->
            assertTrue("Failed at price ${crypto.price}", crypto.price.toDouble() > randomThreshold)
        }
    }

    @Test
    fun `count cryptos below random price`() {
        val cryptoList = loadCryptoList()
        val randomPrice = Random.nextDouble(0.05, 0.3)
        val expectedCount = cryptoList.count { it.price.toDouble() < randomPrice }
        val actualCount = cryptoList.filter { it.price.toDouble() < randomPrice }.size
        assertEquals(expectedCount, actualCount)
    }

    @Test
    fun `find maximum price in crypto list`() {
        val cryptoList = loadCryptoList()
        val maxPrice = cryptoList.maxByOrNull { it.price.toDouble() }?.price?.toDouble() ?: 0.0
        val expectedMaxPrice = cryptoList.map { it.price.toDouble() }.maxOrNull() ?: 0.0
        assertEquals(expectedMaxPrice, maxPrice, 0.0)
    }

    @Test
    fun `average price of cryptos`() {
        val cryptoList = loadCryptoList()
        val averagePrice = cryptoList.map { it.price.toDouble() }.average()
        val expectedAverage = cryptoList.sumOf { it.price.toDouble() } / cryptoList.size
        assertEquals(expectedAverage, averagePrice, 0.0)
    }

    @Test
    fun `check specific currency`() {
        val cryptoList = loadCryptoList()
        val randomCrypto = cryptoList.random().currency
        val containsCurrency = cryptoList.any { it.currency == randomCrypto }
        assertTrue(containsCurrency)
    }
    }
