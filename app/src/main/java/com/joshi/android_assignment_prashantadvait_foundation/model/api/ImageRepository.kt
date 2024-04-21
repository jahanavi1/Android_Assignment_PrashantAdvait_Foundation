package com.joshi.android_assignment_prashantadvait_foundation.model.api

import com.joshi.android_assignment_prashantadvait_foundation.model.data.ImageItem
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ImageRepository {
    private val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    suspend fun getImages(): List<ImageItem> {
        return try {
            apiService.getImages()
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

    companion object {
        private const val BASE_URL = "https://acharyaprashant.org/api/v2/content/misc/"
    }
}