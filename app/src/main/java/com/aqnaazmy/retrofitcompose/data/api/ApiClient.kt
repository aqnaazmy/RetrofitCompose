package com.aqnaazmy.retrofitcompose.data.api

import com.aqnaazmy.retrofitcompose.data.api.model.Photos
import retrofit2.http.GET

interface ApiClient {

    @GET("/photos")
    suspend fun getAllPhotos(): List<Photos>
}