package com.aqnaazmy.retrofitcompose.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aqnaazmy.retrofitcompose.data.api.model.Photos
import com.aqnaazmy.retrofitcompose.data.repository.PhotoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val photoRepository: PhotoRepository
) : ViewModel() {

    private val _state = MutableStateFlow(emptyList<Photos>())
    val state : StateFlow<List<Photos>>
        get() = _state

    init {
        viewModelScope.launch {
            val listPhotos = photoRepository.getAllPhotos()
            _state.value = listPhotos
        }
    }
}