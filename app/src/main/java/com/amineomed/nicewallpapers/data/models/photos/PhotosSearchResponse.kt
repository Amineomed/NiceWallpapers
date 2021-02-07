package com.amineomed.nicewallpapers.data.models.photos

data class PhotosSearchResponse(
    val results: List<Photo>,
    val total: Int,
    val total_pages: Int
)