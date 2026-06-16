package com.learning.exp.model.roomdb

import com.learning.exp.model.dataclasses.lahanga.LahangaDetails

class DatabaseHelperImpl(private val cartDatabase: CartDatabase) : DatabaseHelper {
    override suspend fun getCartList(): List<LahangaDetails> = cartDatabase.cartDao().getCartList()
    override suspend fun addToCart(cartItem: LahangaDetails) = cartDatabase.cartDao().addToCart(cartItem)
    override suspend fun deleteFromCart(cartItem: LahangaDetails) = cartDatabase.cartDao().deleteFromCart(cartItem)

    override suspend fun getWishList(): List<LahangaDetails> = cartDatabase.cartDao().getWishList()
    override suspend fun addToWish(cartItem: LahangaDetails) = cartDatabase.cartDao().addToWish(cartItem)
    override suspend fun deleteFromWish(cartItem: LahangaDetails) = cartDatabase.cartDao().deleteFromWish(cartItem)

}