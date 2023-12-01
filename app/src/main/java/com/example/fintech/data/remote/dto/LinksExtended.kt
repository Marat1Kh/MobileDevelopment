package com.example.fintech.data.remote.dto


import com.example.fintech.data.remote.dto.Stats

data class LinksExtended(
    val stats: Stats,
    val type: String,
    val url: String
)