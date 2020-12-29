package com.amineomed.nicewallpapers.data.models.collections

import com.amineomed.nicewallpapers.data.models.User

data class Collection(
    val cover_photo: CoverPhoto,
    val description: String,
    val id: String,
    val preview_photos: List<PreviewPhoto>,
    val title: String,
    val total_photos: Int,
    val user: User
)