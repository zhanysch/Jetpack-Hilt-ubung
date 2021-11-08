package com.example.jetpaccomposecurency.domain.repository

import com.example.jetpaccomposecurency.data.remote.dto.CoinDetailsDto
import com.example.jetpaccomposecurency.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins():List<CoinDto>

    suspend fun getCoinById(coinId : String):CoinDetailsDto
}