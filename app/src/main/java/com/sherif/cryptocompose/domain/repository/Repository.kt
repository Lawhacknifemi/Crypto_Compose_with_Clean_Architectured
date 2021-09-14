package com.sherif.cryptocompose.domain.repository

import com.sherif.cryptocompose.core.remote.dto.CoinDetailsDto
import com.sherif.cryptocompose.core.remote.dto.CoinDto
import com.sherif.cryptocompose.domain.model.Coin
import com.sherif.cryptocompose.domain.model.CoinDetails

interface Repository {

    suspend fun getCoin() : List<CoinDto>

    suspend fun getCoinDetails(coinId : String) : CoinDetailsDto
}