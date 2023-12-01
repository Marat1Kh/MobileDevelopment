package com.example.fintech.common
//константы для dto
object Constants {

    const val BASE_URL = "https://api.coinpaprika.com/"
    const val PARAM_COIN_ID = "coinId"

    val currList = listOf(
        "RUB", "CAD", "CNY", "EUR", "GBP", "HKD", "INR", "IQD", "JMD", "JPY", "KES", "KPW", "KRW", "KWD", "MKD",
        "MWK", "MXN", "NAD", "NGN", "NZD", "UGX", "USD", "UYU", "VND", "XAG", "XAU"
    )
    val cryptoList = listOf(
        "ADA", "BCD", "BCH", "BNB", "BTC", "BTCA", "DOGE", "DRGN", "EOS", "ERT", "ETC", "ETH", "LEO", "LINDA",
        "LINK", "LTC", "LUN", "MANA", "MIOTA", "TESLA", "THC", "THETA", "THS", "TRUMP", "TRX", "USDT", "WAVES",
        "WAX", "WTC", "XLM", "XTZ", "XMR", "XRP"
    )
}