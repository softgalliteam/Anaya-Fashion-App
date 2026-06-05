package com.learning.exp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.learning.exp.model.CartRepository
import com.learning.exp.model.dataclasses.lahanga.LahangaDetails

class CartViewModel : ViewModel () {
    private val cartItems =
        MutableLiveData<List<LahangaDetails>>()


    fun addToCart(item: LahangaDetails) {

        CartRepository.addToCart(item)

        cartItems.value =
            CartRepository.getCartItems()
    }
    fun loadCart() {
        cartItems.value =
            CartRepository.getCartItems()
    }
}