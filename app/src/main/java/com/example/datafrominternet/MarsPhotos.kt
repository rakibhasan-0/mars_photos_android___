package com.example.datafrominternet

import com.squareup.moshi.Json

data class MarsPhotos (
    @Json (name = "img_src") val imageUrl: String,
    val id: String
)