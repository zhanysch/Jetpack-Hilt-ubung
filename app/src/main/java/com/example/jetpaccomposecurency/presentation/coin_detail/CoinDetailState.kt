package com.example.jetpaccomposecurency.presentation.coin_detail

import com.example.jetpaccomposecurency.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading : Boolean = false,
    val coins : CoinDetail? = null,
    val error : String = ""

)
