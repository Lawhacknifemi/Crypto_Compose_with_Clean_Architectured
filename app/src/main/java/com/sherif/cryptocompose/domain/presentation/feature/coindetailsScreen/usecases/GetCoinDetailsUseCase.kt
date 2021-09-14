package com.sherif.cryptocompose.domain.presentation.feature.coindetailsScreen.usecases

import com.sherif.cryptocompose.common.Resource
import com.sherif.cryptocompose.core.remote.dto.toCoinDetails
import com.sherif.cryptocompose.domain.model.CoinDetails
import com.sherif.cryptocompose.domain.repository.Repository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinDetailsUseCase @Inject constructor(
   private val repository: Repository
){
    operator fun invoke(coinId : String) = flow<Resource<CoinDetails>>  {
        try {
            emit(Resource.Loading())
            val coinDetails = repository.getCoinDetails(coinId).toCoinDetails()
            emit(Resource.Success(coinDetails))
        }catch (e : IOException){
            emit(Resource.Error(e.localizedMessage))
        }catch (e : HttpException){
            emit(Resource.Error(e.localizedMessage))
        }

    }
}
