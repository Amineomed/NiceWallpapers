package com.amineomed.nicewallpapers.data.models.photos

import com.amineomed.nicewallpapers.data.models.Urls
import com.amineomed.nicewallpapers.data.models.User

data class Photo(
    val alt_description: String?,
    val color: String?,
    val created_at: String?,
    val description: String?,
    val id: String?,
    val likes: Int?,
    val urls: Urls,
    val user: User
)