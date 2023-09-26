package com.example.datafrominternet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MarsViewModel: ViewModel() {

    private val _marsPhoto = MutableLiveData<List<MarsPhotos>>()
    val marsPhoto: LiveData<List<MarsPhotos>> get() = _marsPhoto

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    init {
        getPhotos()
    }

    private fun getPhotos() {
        viewModelScope.launch {
            try {
                val fetchPhotos = MarsApi.retrofitService.getPhotos()
                _marsPhoto.value = fetchPhotos
            } catch (e: Exception) {
                _errorMessage.value = "Something went wrong with data fetching"
            }
        }
    }

}
