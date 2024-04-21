package com.joshi.android_assignment_prashantadvait_foundation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joshi.android_assignment_prashantadvait_foundation.model.data.ImageItem
import com.joshi.android_assignment_prashantadvait_foundation.model.api.ImageRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val repository = ImageRepository()
    private val _images = MutableStateFlow<List<ImageItem>>(emptyList())
    val images: StateFlow<List<ImageItem>> = _images

    init {
        fetchImages()
    }

    private fun fetchImages() {
        viewModelScope.launch {
            val images = repository.getImages()
            _images.value = images
        }
    }
}