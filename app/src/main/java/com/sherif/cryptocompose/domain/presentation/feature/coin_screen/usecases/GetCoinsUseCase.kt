package com.sherif.cryptocompose.domain.presentation.feature.coin_screen.usecases

import com.sherif.cryptocompose.common.Resource
import com.sherif.cryptocompose.core.remote.dto.toCoin
import com.sherif.cryptocompose.domain.model.Coin
import com.sherif.cryptocompose.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase  @Inject constructor(
  private val  repository: Repository
){
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoin().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch(e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<List<Coin>>("Couldn't reach server. Check your internet connection."))
        }
    }}