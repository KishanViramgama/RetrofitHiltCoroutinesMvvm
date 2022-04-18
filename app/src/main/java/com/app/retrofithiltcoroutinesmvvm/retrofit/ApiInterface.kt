package com.app.retrofithiltcoroutinesmvvm.retrofit

import com.app.retrofithiltcoroutinesmvvm.item.FreeData
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("bin/astro.php?lon=113.2&lat=23.1&ac=0&unit=metric&output=json&tzshift=0")
    suspend fun getPost(): Response<FreeData>

}