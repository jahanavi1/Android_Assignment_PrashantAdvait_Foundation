package com.joshi.android_assignment_prashantadvait_foundation.model.api

import com.joshi.android_assignment_prashantadvait_foundation.model.data.ImageItem
import retrofit2.http.GET


interface ApiService {
    @GET("media-coverages?limit=100")
    suspend fun getImages(): List<ImageItem>
}
