package com.learning.exp.model

import com.learning.exp.model.dataclasses.lahanga.LahangaDetails
import com.learning.exp.model.dataclasses.lahanga.LahangaResponseDataItem
import retrofit2.http.GET

interface ApiCallRetrofitService {
    @GET("objects")
    suspend fun getComputerList(): ArrayList<LahangaResponseDataItem>

}