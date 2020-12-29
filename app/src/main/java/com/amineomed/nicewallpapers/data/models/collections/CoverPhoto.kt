package com.amineomed.nicewallpapers.data.models.collections

import com.amineomed.nicewallpapers.data.models.Urls
import com.amineomed.nicewallpapers.data.models.User

data class CoverPhoto(
    val color: String,
    val id: String,
    val urls: Urls,
    val user: User
)