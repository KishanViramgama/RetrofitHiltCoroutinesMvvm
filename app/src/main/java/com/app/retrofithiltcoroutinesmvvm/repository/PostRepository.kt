package com.app.retrofithiltcoroutinesmvvm.repository

import com.app.retrofithiltcoroutinesmvvm.item.FreeData
import com.app.retrofithiltcoroutinesmvvm.retrofit.ApiInterface
import retrofit2.Response
import javax.inject.Inject

class PostRepository @Inject constructor(private val apiInterface: ApiInterface) {

    suspend fun getData(): Response<FreeData> {
        return apiInterface.getPost()
    }

}