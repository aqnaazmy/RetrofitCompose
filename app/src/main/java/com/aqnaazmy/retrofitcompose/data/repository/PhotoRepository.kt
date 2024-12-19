package com.aqnaazmy.retrofitcompose.data.repository

import com.aqnaazmy.retrofitcompose.data.api.ApiClient
import com.aqnaazmy.retrofitcompose.data.api.model.Photos
import javax.inject.Inject

class PhotoRepository @Inject constructor(
    private val apiClient: ApiClient
){
    suspend fun getAllPhotos() : List<Photos> {
        return apiClient.getAllPhotos()
    }
}