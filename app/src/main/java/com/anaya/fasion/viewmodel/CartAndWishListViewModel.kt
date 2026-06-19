package com.anaya.fasion.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.anaya.fasion.model.ApiCalRepository
import com.anaya.fasion.model.lahanga.LahangaDetails
import com.anaya.fasion.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

sealed class Status {
    object Loading : Status()
    data class Success(val cartList: List<LahangaDetails>) : Status()
    data class WishSuccess(val wishList: List<LahangaDetails>) : Status()
    data class SuccessWithMessage(val message: String) : Status()
    data class Error(val message: String) : Status()
}

class CartAndWishListViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val repository by lazy {
        ApiCalRepository("Cart", application)
    }

    private val wishRepository by lazy {
        ApiCalRepository("Wish", application)
    }

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

                val cartList = repository.getCartList()

                Log.d(Constants.TAG, "Cart List: $cartList")

                if (cartList.isEmpty()) {
                    _cartState.postValue(
                        Status.Error("Cart data no found")
                    )
                } else {
                    _cartState.postValue(
                        Status.Success(cartList)
                    )
                }

            } catch (e: Exception) {

                _cartState.postValue(
                    Status.Error(e.message ?: "Something went wrong")
                )
            }
        }
    }

    fun getWishList() {
        viewModelScope.launch(Dispatchers.IO) {

            _wishState.postValue(Status.Loading)

            try {

                val wishList = wishRepository.getWishList()

                Log.d(Constants.TAG, "Wish List: $wishList")

                if (wishList.isEmpty()) {
                    _wishState.postValue(
                        Status.Error("Wishlist data no found")
                    )
                } else {
                    _wishState.postValue(
                        Status.WishSuccess(wishList)
                    )
                }

            } catch (e: Exception) {

                _wishState.postValue(
                    Status.Error(e.message ?: "Something went wrong")
                )
            }
        }
    }

    fun deleteFromCart(item: LahangaDetails) {
        viewModelScope.launch(Dispatchers.IO) {

            try {

                repository.deleteCartListItem(item)

                // Cart refresh after delete
                val updatedList = repository.getCartList()

                if (updatedList.isEmpty()) {
                    _cartState.postValue(
                        Status.Error("Cart no data found")
                    )
                } else {
                    _cartState.postValue(
                        Status.Success(updatedList)
                    )
                }

            } catch (e: Exception) {

                _cartState.postValue(
                    Status.Error(e.message ?: "Delete failed")
                )
            }
        }
    }

    fun deleteFromWish(item: LahangaDetails) {
        viewModelScope.launch(Dispatchers.IO) {

            try {

                wishRepository.deleteWishListItem(item)

                val updatedList = wishRepository.getWishList()

                if (updatedList.isEmpty()) {
                    _wishState.postValue(
                        Status.Error("Wishlist data no found ")
                    )
                } else {
                    _wishState.postValue(
                        Status.WishSuccess(updatedList)
                    )
                }

            } catch (e: Exception) {

                _wishState.postValue(
                    Status.Error(e.message ?: "Delete failed")
                )
            }
        }
    }
}