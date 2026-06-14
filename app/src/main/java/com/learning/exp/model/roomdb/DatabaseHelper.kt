package com.learning.exp.model.roomdb

import com.learning.exp.model.dataclasses.lahanga.LahangaDetails

interface DatabaseHelper {
    suspend fun getCartList(): List<LahangaDetails>
    suspend fun addToCart(cartItem: LahangaDetails)
    suspend fun deleteFromCart(cartItem: LahangaDetails)


    suspend fun getWishList(): List<LahangaDetails>
    suspend fun addToWish(cartItem: LahangaDetails)
    suspend fun deleteFromWish(cartItem: LahangaDetails)
}