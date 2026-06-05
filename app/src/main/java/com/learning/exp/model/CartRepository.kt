package com.learning.exp.model

import com.learning.exp.model.dataclasses.lahanga.LahangaDetails

object CartRepository {
     private val cartItems = mutableListOf<LahangaDetails>()

    fun addToCart(item: LahangaDetails){
        cartItems.add(item)
    }

    fun getCartItems(): List<LahangaDetails> {
        return cartItems
    }
}