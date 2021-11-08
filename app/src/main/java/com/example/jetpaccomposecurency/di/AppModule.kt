package com.example.jetpaccomposecurency.di

import com.example.jetpaccomposecurency.common.Constants
import com.example.jetpaccomposecurency.data.remote.CoinPaprikaApi
import com.example.jetpaccomposecurency.data.repository.CoinReposirotyImpl
import com.example.jetpaccomposecurency.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)  // живет столько сколько живет сам класс aplication
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi():CoinPaprikaApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api:CoinPaprikaApi):CoinRepository{
          return CoinReposirotyImpl(api)
    }
}