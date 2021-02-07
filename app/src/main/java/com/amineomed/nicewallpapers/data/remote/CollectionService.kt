package com.amineomed.nicewallpapers.data.remote

import com.amineomed.nicewallpapers.data.models.collections.Collection
import com.amineomed.nicewallpapers.data.models.photos.Photo
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CollectionService {

    // Get a single page from the list of all collections.
    @GET("collections")
    suspend fun getCollections(
        @Query("page") page: Int?, // Page number to retrieve. (Optional; default: 1)
        @Query("per_page") perPage: Int?, // Number of items per page. (Optional; default: 10)
    ): List<Collection>

    // Retrieve a single collection by Id
    @GET("collections/{id}")
    suspend fun getCollection(
        @Path("id") collectionId: String // The collections’s ID. Required.
    ): Collection

    // Retrieve a collection’s photos.
    @GET("collections/{id}/photos")
    suspend fun getCollectionPhotos(
        @Query("id") collectionId: String,
        @Query("page") page: Int?, // Page number to retrieve. (Optional; default: 1)
        @Query("per_page") perPage: Int?, // Number of items per page. (Optional; default: 10)
        @Query("orientation") orientation: String? // Filter by photo orientation. Optional. (Valid values: landscape, portrait, squarish)
    ): List<Photo>
}