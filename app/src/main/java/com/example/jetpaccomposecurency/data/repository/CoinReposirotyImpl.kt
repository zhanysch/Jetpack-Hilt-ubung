package com.example.jetpaccomposecurency.data.repository

import com.example.jetpaccomposecurency.data.remote.CoinPaprikaApi
import com.example.jetpaccomposecurency.data.remote.dto.CoinDetailsDto
import com.example.jetpaccomposecurency.data.remote.dto.CoinDto
import com.example.jetpaccomposecurency.domain.repository.CoinRepository
import javax.inject.Inject

class CoinReposirotyImpl @Inject constructor(
    private val api : CoinPaprikaApi
): CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return  api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailsDto {
        return api.getCoinById(coinId)
    }
}