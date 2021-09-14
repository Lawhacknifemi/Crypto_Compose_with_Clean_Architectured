package com.sherif.cryptocompose.domain.presentation.feature.coin_screen

import com.sherif.cryptocompose.domain.model.Coin

data class CoinListState (
    val isLoading : Boolean = false,
    val coins :List<Coin> = emptyList(),
    val error : String = ""
        )