package com.learning.exp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.learning.exp.model.ApiCalRepository
import com.learning.exp.model.dataclasses.lahanga.LahangaDetails
import com.learning.exp.model.dataclasses.lahanga.LahangaResponseDataItem
import com.learning.exp.model.roomdb.CartDatabase
import com.learning.exp.model.roomdb.DatabaseBuilder
import com.learning.exp.model.roomdb.DatabaseHelper
import com.learning.exp.model.roomdb.DatabaseHelperImpl
import com.learning.exp.utils.Constants.TAG
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

sealed class Status {
    object Loading : Status()
    data class Success(val cartList: List<LahangaDetails>) : Status()
    data class SuccessWithMessage(val message: String) : Status()
    data class Error(val message: String) : Status()
}


class CartAndWishListViewModel(private val repository: ApiCalRepository) : ViewModel() {
    private val _cartState = MutableLiveData<Status>()
    val cartState: MutableLiveData<Status>
        get() = _cartState

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

    class CartAndWishListViewModelFactory(
        private val repository: ApiCalRepository
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(CartAndWishListViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return CartAndWishListViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}