package com.aqnaazmy.retrofitcompose.di

import com.aqnaazmy.retrofitcompose.data.api.ApiClient
import com.aqnaazmy.retrofitcompose.data.utils.Constans.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit.Builder {
     return Retrofit
         .Builder()
         .baseUrl(BASE_URL)
         .addConverterFactory(GsonConverterFactory.create())
    }
    @Provides
    @Singleton
    fun provideApiCLient(builder: Retrofit.Builder): ApiClient{
        return builder
            .build()
            .create(ApiClient::class.java)
    }
}