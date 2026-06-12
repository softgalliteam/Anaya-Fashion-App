package com.learning.exp.model

import com.learning.exp.model.dataclasses.lahanga.LahangaDetails
import com.learning.exp.model.dataclasses.lahanga.LahangaResponseDataItem
import com.learning.exp.model.dataprovider.LahangaDataProvider
import com.learning.exp.model.roomdb.DatabaseBuilder
import com.learning.exp.model.roomdb.DatabaseHelper
import com.learning.exp.utils.Constants.BASE_URL_RETROFIT
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiCalRepository(private val cartDbHelper: DatabaseHelper) {
    suspend fun getComputerListFromRetrofit(): ArrayList<LahangaResponseDataItem> {

        // Retrofit to make network request
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL_RETROFIT)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiCallRetrofitService::class.java)
        val computerList = apiService.getComputerList()
        return computerList
    }

    // Local DB Room
    suspend fun getLahangaListFromRoomDb(): ArrayList<LahangaResponseDataItem> {
        // Use Local Room DB Here

        return LahangaDataProvider.getLahangaList()
    }

    // Local DB Room
    suspend fun getLahangaDetails(id: Int): LahangaDetails? {
        // Use Local Room DB Here

        return LahangaDataProvider.getLahangaDetailsById(id)
    }

    suspend fun addToCart(item: LahangaDetails) {
        // Use Local Room DB Here to add item to cart
        cartDbHelper.addToCart(item)
    }
    suspend fun getCartList(): List<LahangaDetails> {
        return cartDbHelper.getCartList()
    }
}
