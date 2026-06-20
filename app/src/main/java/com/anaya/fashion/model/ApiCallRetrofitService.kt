package com.anaya.fashion.model

import com.anaya.fashion.model.lahanga.LahangaResponseDataItem
import retrofit2.http.GET

interface ApiCallRetrofitService {
    @GET("objects")
    suspend fun getComputerList(): ArrayList<LahangaResponseDataItem>

}