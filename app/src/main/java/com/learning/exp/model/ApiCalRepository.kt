package com.learning.exp.model

import com.learning.exp.model.dataclasses.lahanga.LahangaDetails
import com.learning.exp.model.dataclasses.lahanga.LahangaResponseDataItem
import com.learning.exp.model.dataprovider.LahangaDataProvider
import com.learning.exp.model.roomdb.DatabaseBuilder
import com.learning.exp.model.roomdb.DatabaseHelper
import com.learning.exp.model.roomdb.DatabaseHelperImpl
import com.learning.exp.utils.Constants.BASE_URL_RETROFIT
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiCalRepository(
    private val fromWhichScreen: String,
    private val application: android.app.Application
) {
    private val dbHelper: DatabaseHelper = initialiseDbHelper()

    private fun initialiseDbHelper(): DatabaseHelper {

        val cartDb = if (fromWhichScreen == "Cart") {
            DatabaseBuilder.getCartDbInstance(application)
        } else {
            DatabaseBuilder.getWishListDbInstance(application)
        }
        return DatabaseHelperImpl(cartDb)
    }

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

    suspend fun searchLahangaList(searchText: String): ArrayList<LahangaResponseDataItem> {
        // Use Local Room DB Here

        return LahangaDataProvider.searchProduct(searchText)
    }

    // Local DB Room
    suspend fun getLahangaDetails(id: Int): LahangaDetails? {
        // Use Local Room DB Here

        return LahangaDataProvider.getLahangaDetailsById(id)
    }

    suspend fun addToCart(item: LahangaDetails) {
        // Use Local Room DB Here to add item to cart
        dbHelper.addToCart(item)
    }

    suspend fun getCartList(): List<LahangaDetails> {
        return dbHelper.getCartList()
    }

    suspend fun deleteCartListItem(item: LahangaDetails) {
        return dbHelper.deleteFromCart(item)
    }

    suspend fun addToWish(item: LahangaDetails) {
        // Use Local Room DB Here to add item to cart
        dbHelper.addToWish(item)
    }

    suspend fun getWishList(): List<LahangaDetails> {
        return dbHelper.getWishList()
    }

    suspend fun deleteWishListItem(item: LahangaDetails) {
        return dbHelper.deleteFromWish(item)
    }
}
