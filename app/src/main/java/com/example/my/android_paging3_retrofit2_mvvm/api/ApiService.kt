package com.example.my.android_paging3_retrofit2_mvvm.api

import com.example.my.android_paging3_retrofit2_mvvm.model.ResponseApi
import com.example.my.android_paging3_retrofit2_mvvm.utils.Constants
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(Constants.END_POINT)
    suspend fun getAllCharacters(
        @Query("count") size: Int
    ): Response<ResponseApi>

}