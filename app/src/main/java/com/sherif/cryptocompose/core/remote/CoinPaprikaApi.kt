package com.sherif.cryptocompose.core.remote

import com.sherif.cryptocompose.core.remote.dto.CoinDetailsDto
import com.sherif.cryptocompose.core.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoin() : List<CoinDto>

    @GET("coins/{coin_id}")
    suspend fun getCoinDetails(@Path("coin_id") coinID : String) : CoinDetailsDto

}