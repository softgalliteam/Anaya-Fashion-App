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


class ApiCallViewModel(private val repository: ApiCalRepository) : ViewModel() {
    private var productDetails: LahangaDetails? = null
    private val _screenState = MutableLiveData<ApiCallState>()
    val screenState: MutableLiveData<ApiCallState>
        get() = _screenState

    private val _detailScreenState = MutableLiveData<ApiCallState?>()
    val detailScreenState: MutableLiveData<ApiCallState?>
        get() = _detailScreenState

    fun getLahangaList() {
        viewModelScope.launch(Dispatchers.IO) {
            _screenState.postValue(ApiCallState.Loading)
            try {
                // Remote API
                //val response = repository.getComputerListFromRetrofit()

                // Use Local Room DB
                val lahangaList = repository.getLahangaListFromRoomDb()

                Log.d(TAG, "Response from repository: $lahangaList")
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
                productDetails = repository.getLahangaDetails(id)

                Log.d(TAG, "Response from repository: $productDetails")
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
                repository.addToCart(productDetails!!)
                Log.d(TAG, "Item added to cart: $productDetails")
                _detailScreenState.postValue(DetailsApiCallState.SuccessWithMessage("Item added to cart successfully"))
            } catch (e: Exception) {
                Log.e(TAG, "Error adding item to cart: ${e.message}")
            }
        }
    }

    class ApiCallViewModelFactory(
        private val repository: ApiCalRepository
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ApiCallViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return ApiCallViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}