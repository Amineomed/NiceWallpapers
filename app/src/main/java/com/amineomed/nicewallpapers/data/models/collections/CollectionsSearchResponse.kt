package com.amineomed.nicewallpapers.data.models.collections

data class CollectionsSearchResponse(
    val results: List<Collection>,
    val total: Int,
    val total_pages: Int
)