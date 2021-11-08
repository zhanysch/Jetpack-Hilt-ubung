package com.example.jetpaccomposecurency.domain.use_case.get_coins

import com.example.jetpaccomposecurency.common.Resource
import com.example.jetpaccomposecurency.data.remote.dto.toCoin
import com.example.jetpaccomposecurency.domain.model.Coin
import com.example.jetpaccomposecurency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.util.concurrent.Flow
import javax.inject.Inject

class CoinsUseCase @Inject constructor(
    private val repository : CoinRepository
) {
    operator fun invoke() : kotlinx.coroutines.flow.Flow<Resource<List<Coin>>> = flow {
        try {

             emit(Resource.Loading<List<Coin>>()) // для прогресБара
           val coins = repository.getCoins().map { it.toCoin() }  //map я добавил птм.. что тут моделька Coin,
            // а в методе getCoins() моделька CoinDto чтб он их указал так чтоб одно и тоже Нурдолот!!!
            emit(Resource.Success<List<Coin>>(coins))
        }catch (e:HttpException){
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "an unexpected error"))
        }catch (e : IOException){
           emit(Resource.Error<List<Coin>>(" Чувак у тебя с интернетом не бум бум, проверь соединение "))
        }
    }
}