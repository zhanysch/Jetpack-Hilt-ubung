package com.example.jetpaccomposecurency.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpaccomposecurency.common.Constants
import com.example.jetpaccomposecurency.common.Resource
import com.example.jetpaccomposecurency.domain.model.CoinDetail
import com.example.jetpaccomposecurency.domain.use_case.get_coin_simple.CoinUseCase
import com.example.jetpaccomposecurency.domain.use_case.get_coins.CoinsUseCase
import com.example.jetpaccomposecurency.presentation.coin_list.CoinListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: CoinUseCase,
    private val savedStateHandle : SavedStateHandle // передает данные через VM и сохраняет состояние
): ViewModel() {

    private val _state = mutableStateOf(CoinDetailState()) // для состояния
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            getCoin(coinId)
        }
    }

    private fun getCoin(coinId:String){
        getCoinUseCase(coinId).onEach { result ->
            when(result){
                is Resource.Success ->{
                 _state.value = CoinDetailState(coins = result.data )
                }
                is Resource.Error -> {
                   _state.value = CoinDetailState(error = result.message ?: "сенде катта чыкты")
                }
                is Resource.Loading -> {
                    _state.value = CoinDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
