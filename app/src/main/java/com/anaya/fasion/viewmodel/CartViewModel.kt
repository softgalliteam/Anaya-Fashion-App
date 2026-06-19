package com.anaya.fasion.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anaya.fasion.model.CartRepository
import com.anaya.fasion.model.lahanga.LahangaDetails

class CartViewModel : ViewModel() {
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