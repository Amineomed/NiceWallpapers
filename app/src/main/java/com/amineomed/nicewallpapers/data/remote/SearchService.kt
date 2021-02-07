package com.amineomed.nicewallpapers.data.remote

import com.amineomed.nicewallpapers.data.models.collections.CollectionsSearchResponse
import com.amineomed.nicewallpapers.data.models.photos.PhotosSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {

    // Get a single page of photo results for a query.
    @GET("search/photos")
    suspend fun getPhotosSearch(
        @Query("query") query: String, // Search terms.
        @Query("page") page: Int?, // Page number to retrieve. (Optional; default: 1)
        @Query("per_page") perPage: Int?, // Number of items per page. (Optional; default: 10)
        @Query("order_by") orderBy: String?, // How to sort the photos. (Optional; default: relevant). Valid values are latest and relevant.
        @Query("content_filter") contentFilter: String?, // Limit results by content safety. (Optional; default: low). Valid values are low and high.
        @Query("color") color: String?, // Filter results by color. Optional. Valid values are: black_and_white, black, white, yellow, orange, red, purple, magenta, green, teal, and blue.
        @Query("orientation") orientation: String?, // Filter by photo orientation. Optional. (Valid values: landscape, portrait, squarish)
    ): PhotosSearchResponse

    // Get a single page of collection results for a query.
    @GET("search/collections")
    suspend fun getCollectionsSearch(
        @Query("query") query: String, // Search terms.
        @Query("page") page: Int?, // Page number to retrieve. (Optional; default: 1)
        @Query("per_page") perPage: Int?, // Number of items per page. (Optional; default: 10)
    ): CollectionsSearchResponse
}