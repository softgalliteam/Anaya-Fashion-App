package com.learning.exp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learning.exp.model.ApiCalRepository
import com.learning.exp.model.dataclasses.lahanga.LahangaDetails
import com.learning.exp.model.dataclasses.lahanga.LahangaResponseDataItem
import com.learning.exp.utils.Constants.TAG
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


sealed class ApiCallState {
    object Loading : ApiCallState()
    data class Success(val articles: ArrayList<LahangaResponseDataItem>) : ApiCallState()
    data class Error(val message: String) : ApiCallState()
}

sealed class DetailsApiCallState {
    object Loading : ApiCallState()
    data class Success(val articles: LahangaDetails) : ApiCallState()
    data class Error(val message: String) : ApiCallState()
}


class ApiCallViewModel : ViewModel() {
    private val _screenState = MutableLiveData<ApiCallState>()
    val screenState: MutableLiveData<ApiCallState>
        get() = _screenState

    private val _detailScreenState = MutableLiveData<ApiCallState?>()
    val detailScreenState: MutableLiveData<ApiCallState?>
        get() = _detailScreenState


    private val repository = ApiCalRepository()
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
                val lahangaDetails = repository.getLahangaDetails(id)

                Log.d(TAG, "Response from repository: $lahangaDetails")
                if (lahangaDetails == null) {
                    _detailScreenState.postValue(DetailsApiCallState.Error("No data found for Lahanga with ID: $id"))
                } else {
                    _detailScreenState.postValue(DetailsApiCallState.Success(lahangaDetails))
                }
            } catch (e: Exception) {
                _detailScreenState.postValue(DetailsApiCallState.Error("Error fetching articles: ${e.message}"))
            }
        }
    }

}