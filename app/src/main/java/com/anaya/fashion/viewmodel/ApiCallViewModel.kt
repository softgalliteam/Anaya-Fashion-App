package com.anaya.fashion.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.anaya.fashion.model.ApiCalRepository
import com.anaya.fashion.model.lahanga.LahangaDetails
import com.anaya.fashion.model.lahanga.LahangaResponseDataItem
import com.anaya.fashion.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


sealed class ApiCallState {
    object Loading : ApiCallState()
    data class Success(val articles: ArrayList<LahangaResponseDataItem>) : ApiCallState()
    data class SuccessWithMessage(val message: String) : ApiCallState()
    data class Error(val message: String) : ApiCallState()
}

sealed class DetailsApiCallState {
    object Loading : ApiCallState()
    data class Success(val articles: LahangaDetails) : ApiCallState()
    data class SuccessWithMessage(val message: String) : ApiCallState()
    data class Error(val message: String) : ApiCallState()
}


class ApiCallViewModel(
    private val application: Application
) : AndroidViewModel(application) {
    val cartRepository by lazy { ApiCalRepository("Cart", application) }
    val wishRepository by lazy { ApiCalRepository("Wish", application) }


    private var productDetails: LahangaDetails? = null
    private val _screenState = MutableLiveData<ApiCallState>()
    val screenState: MutableLiveData<ApiCallState>
        get() = _screenState

    private val _detailScreenState = MutableLiveData<ApiCallState?>()
    val detailScreenState: MutableLiveData<ApiCallState?>
        get() = _detailScreenState

    private val _wishListState = MutableLiveData<Boolean>()
    val wishListStateState: MutableLiveData<Boolean>
        get() = _wishListState

    fun getLahangaList(fromWhichScreen: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _screenState.postValue(ApiCallState.Loading)
            try {
                // Remote API
                //val response = repository.getComputerListFromRetrofit()

                // Use Local Room DB
                val lahangaList = cartRepository.getLahangaListFromRoomDb(fromWhichScreen)

                Log.d(Constants.TAG, "Response from repository: $lahangaList")
                if (lahangaList.isEmpty()) {
                    _screenState.postValue(ApiCallState.Error("No data found in Room DB"))
                } else {
                    _screenState.postValue(ApiCallState.Success(lahangaList))
                }
            } catch (e: Exception) {
                _screenState.postValue(ApiCallState.Error("Error fetching articles: ${e.message}"))
            }
        }
    }


    fun getLahangaDetails(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _detailScreenState.postValue(DetailsApiCallState.Loading)
            try {
                // Use Local Room DB
                productDetails = cartRepository.getLahangaDetails(id)

                handleWishListIcon()
                Log.d(Constants.TAG, "Response from repository: $productDetails")
                if (productDetails == null) {
                    _detailScreenState.postValue(DetailsApiCallState.Error("No data found for Lahanga with ID: $id"))
                } else {
                    _detailScreenState.postValue(DetailsApiCallState.Success(productDetails!!))
                }
            } catch (e: Exception) {
                _detailScreenState.postValue(DetailsApiCallState.Error("Error fetching articles: ${e.message}"))
            }
        }
    }


    fun addToCart() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                cartRepository.addToCart(productDetails!!)
                Log.d(Constants.TAG, "Item added to cart: $productDetails")
                _detailScreenState.postValue(DetailsApiCallState.SuccessWithMessage("Item added to cart successfully"))
            } catch (e: Exception) {
                Log.e(Constants.TAG, "Error adding item to cart: ${e.message}")
            }
        }
    }

    fun handleWishList() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                if (isToAddInWishlist()) {
                    wishRepository.deleteWishListItem(productDetails!!)
                    Log.d(Constants.TAG, "Item is removed from wish list: $productDetails")
                    _wishListState.postValue(false)
                } else {
                    wishRepository.addToWish(productDetails!!)
                    Log.d(Constants.TAG, "Item added to wish list: $productDetails")
                    _wishListState.postValue(true)
                }
            } catch (e: Exception) {
                Log.e(Constants.TAG, "Error adding item to wish list: ${e.message}")
            }
        }
    }

    suspend fun handleWishListIcon() {
        try {
            if (isToAddInWishlist()) {
                _wishListState.postValue(true)
            } else {
                _wishListState.postValue(false)
            }
        } catch (e: Exception) {
            Log.e(Constants.TAG, "Error adding item to wish list: ${e.message}")
        }
    }

    private suspend fun isToAddInWishlist(): Boolean {
        return wishRepository.isAlreadyAddedInWishList(productDetails!!)
    }

    fun searchLahangaList(fromWhichScreen: String, searchText: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _screenState.postValue(ApiCallState.Loading)
            try {
                val filteredList = cartRepository.searchLahangaList(fromWhichScreen, searchText)
                if (filteredList.isEmpty()) {
                    _screenState.postValue(ApiCallState.Error("No results found for \"$searchText\""))
                } else {
                    _screenState.postValue(ApiCallState.Success(filteredList))
                }
            } catch (e: Exception) {
                _screenState.postValue(ApiCallState.Error("Error searching articles: ${e.message}"))
            }
        }
    }
}