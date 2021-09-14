package com.sherif.cryptocompose.core.repository

import com.sherif.cryptocompose.core.remote.CoinPaprikaApi
import com.sherif.cryptocompose.core.remote.dto.CoinDetailsDto
import com.sherif.cryptocompose.core.remote.dto.CoinDto
import com.sherif.cryptocompose.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
   private val  api: CoinPaprikaApi
) : Repository {

    override suspend fun getCoin(): List<CoinDto> {
        return api.getCoin()
    }

    override suspend fun getCoinDetails(coinId: String): CoinDetailsDto {
        return api.getCoinDetails(coinId)
    }
}