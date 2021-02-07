package com.amineomed.nicewallpapers.data.remote

import com.amineomed.nicewallpapers.data.models.photos.Photo
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PhotoService {

    // Get a single page from the list of all photos.
    @GET("photos")
    suspend fun getPhotosList(
        @Query("page") page: Int?, // Page number to retrieve. (Optional; default: 1)
        @Query("per_page") perPage: Int?, // Number of items per page. (Optional; default: 10)
        @Query("order_by") orderBy: String?, // How to sort the photos. Optional. (Valid values: latest, oldest, popular; default: latest)
    ): List<Photo>

    // Retrieve a single photo by id.
    @GET("photos/{id}")
    suspend fun getPhoto(
        @Path("id") photoId: String // The photo’s ID. Required
    ): Photo

    // Retrieve a single random photo, given optional filters.
    @GET("photos/random")
    suspend fun getRandomPhoto(
        @Query("collections") collectionId: String?, // Public collection ID(‘s) to filter selection. If multiple, comma-separated
        @Query("featured") featured: String?, // Limit selection to featured photos.
        @Query("username") username: String?, // Limit selection to a single user.
        @Query("query") query: String?, // Limit selection to photos matching a search term.
        @Query("orientation") orientation: String?, // Filter by photo orientation. (Valid values: landscape, portrait, squarish)
        @Query("content_filter") contentFilter: String? // Limit results by content safety. Default: low. Valid values are low and high.
    ): Photo
    //Note: You can’t use the collections and query parameters in the same request
}