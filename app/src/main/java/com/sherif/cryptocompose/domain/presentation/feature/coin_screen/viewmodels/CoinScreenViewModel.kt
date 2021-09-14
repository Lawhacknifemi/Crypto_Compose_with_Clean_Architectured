package com.sherif.cryptocompose.domain.presentation.feature.coin_screen.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sherif.cryptocompose.common.Resource
import com.sherif.cryptocompose.domain.presentation.feature.coin_screen.CoinListState
import com.sherif.cryptocompose.domain.presentation.feature.coin_screen.usecases.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class CoinScreenViewModel  @Inject constructor(
  private val getCoinsUseCase: GetCoinsUseCase
): ViewModel() {

    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state


    init {
        getCoins()
    }

    fun getCoins(){
        getCoinsUseCase().onEach { result->
            when(result){

               is Resource.Success ->{
                    _state.value = CoinListState(coins = result.data ?: emptyList() )
                }
                is Resource.Error ->{
                    _state.value = CoinListState(error = result.message ?: "An un expected Erro" +
                    "r Occurred!")

                    Timber.d("It was an error")

                }
                is Resource.Loading ->{
                    _state.value = CoinListState(isLoading = true)
                    Timber.d("It's Loadinging")
                }

            }

        }.launchIn(viewModelScope)
    }

}