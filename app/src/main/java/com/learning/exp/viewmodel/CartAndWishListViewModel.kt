package com.learning.exp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.learning.exp.model.ApiCalRepository
import com.learning.exp.model.dataclasses.lahanga.LahangaDetails
import com.learning.exp.utils.Constants.TAG
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

sealed class Status {
    object Loading : Status()
    data class Success(val cartList: List<LahangaDetails>) : Status()
    data class WishSuccess(val wishList: List<LahangaDetails>) : Status()
    data class SuccessWithMessage(val message: String) : Status()
    data class Error(val message: String) : Status()
}


class CartAndWishListViewModel(
    private val application: Application
) : AndroidViewModel(application) {
    val repository by lazy { ApiCalRepository("Cart", application) }
    val wishRepository by lazy { ApiCalRepository("Wish", application) }


    private val _cartState = MutableLiveData<Status>()
    val cartState: MutableLiveData<Status>
        get() = _cartState

    private val _wishState = MutableLiveData<Status>()
    val wishState: MutableLiveData<Status>
        get() = _wishState

    fun getCartList() {
        viewModelScope.launch(Dispatchers.IO) {
            _cartState.postValue(Status.Loading)
            try {
                delay(2000) // Simulate loading delay
                val cartList = repository.getCartList()

                Log.d(TAG, "Response from repository: $cartList")
                if (cartList.isEmpty()) {
                    _cartState.postValue(Status.Error("No data found in Room DB"))
                } else {
                    _cartState.postValue(Status.Success(cartList))
                }
            } catch (e: Exception) {
                _cartState.postValue(Status.Error("Error fetching articles: ${e.message}"))
            }
        }
    }

    fun getWishList() {
        viewModelScope.launch(Dispatchers.IO) {
            _wishState.postValue(Status.Loading)
            try {
                delay(2000) // Simulate loading delay
                val cartList = wishRepository.getWishList()

                Log.d(TAG, "Response from repository: $cartList")
                if (cartList.isEmpty()) {
                    _wishState.postValue(Status.Error("No data found in Room DB"))
                } else {
                    _wishState.postValue(Status.WishSuccess(cartList))
                }
            } catch (e: Exception) {
                _wishState.postValue(Status.Error("Error fetching articles: ${e.message}"))
            }
        }
    }
}