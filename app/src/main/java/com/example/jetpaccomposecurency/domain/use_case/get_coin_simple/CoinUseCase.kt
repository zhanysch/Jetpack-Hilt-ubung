package com.example.jetpaccomposecurency.domain.use_case.get_coin_simple

import com.example.jetpaccomposecurency.common.Resource
import com.example.jetpaccomposecurency.data.remote.dto.toCoinDetail
import com.example.jetpaccomposecurency.domain.model.CoinDetail
import com.example.jetpaccomposecurency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinUseCase @Inject constructor(
    private val repository : CoinRepository
) {
    operator fun invoke(coinId: String) : kotlinx.coroutines.flow.Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>()) // для прогресБара
           val coins = repository.getCoinById(coinId).toCoinDetail()  //map я добавил птм.. что тут моделька Coin,
            // а в методе getCoinById() моделька CoinDto чтб он их указал так чтоб одно и тоже Нурдолот!!!
            emit(Resource.Success<CoinDetail>(coins))
        }catch (e:HttpException){
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "an unexpected error"))
        }catch (e : IOException){
           emit(Resource.Error<CoinDetail>(" Чувак у тебя с интернетом не бум бум, проверь соединение "))
        }
    }
}