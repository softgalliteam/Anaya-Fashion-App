package com.anaya.fashion.model

import com.anaya.fashion.model.lahanga.LahangaDetails

object CartRepository {

    private val cartItems = mutableListOf<LahangaDetails>()

    // Add item
    fun addToCart(item: LahangaDetails) {
        cartItems.add(item)
    }

    // Get all items
    fun getCartItems(): List<LahangaDetails> {
        return cartItems
    }

    // Remove item (FIXED)
    fun removeFromCart(item: LahangaDetails) {
        cartItems.remove(item)
    }

}