package com.acabes.imageapiapplication

import retrofit2.Response
import retrofit2.http.GET

interface APIinterface {
    @GET("/v1/sample-data/photos")
    suspend fun getImg() : Response<ImageResult>
}