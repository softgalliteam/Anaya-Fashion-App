package com.learning.exp.model.roomdb

import com.learning.exp.model.dataclasses.lahanga.LahangaDetails

class DatabaseHelperImpl(private val cartDatabase: CartDatabase) : DatabaseHelper {
    override suspend fun getCartList(): List<LahangaDetails> = cartDatabase.cartDao().getCartList()
    override suspend fun addToCart(cartItem: LahangaDetails) = cartDatabase.cartDao().addToCart(cartItem)
    override suspend fun deleteFromCart(cartItem: LahangaDetails) = cartDatabase.cartDao().deleteFromCart(cartItem)
}