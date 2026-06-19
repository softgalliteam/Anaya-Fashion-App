package com.anaya.fasion.model

import com.anaya.fasion.model.lahanga.LahangaResponseDataItem
import retrofit2.http.GET

interface ApiCallRetrofitService {
    @GET("objects")
    suspend fun getComputerList(): ArrayList<LahangaResponseDataItem>

}