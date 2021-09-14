package com.sherif.cryptocompose.di

import com.sherif.cryptocompose.common.Constants.BASE_URL
import com.sherif.cryptocompose.core.remote.CoinPaprikaApi
import com.sherif.cryptocompose.core.repository.RepositoryImpl
import com.sherif.cryptocompose.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesCoinPapricaApi(): CoinPaprikaApi{

        val logging = HttpLoggingInterceptor()
        logging.level = (HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
        client.addInterceptor(logging)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client.build())
            .build()
            .create(CoinPaprikaApi::class.java)
    }
    @Provides
    @Singleton
    fun providesRepository (api :CoinPaprikaApi) : Repository{
        return RepositoryImpl(api)
    }

}