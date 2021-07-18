package com.amineomed.nicewallpapers.repositories

import com.amineomed.nicewallpapers.data.remote.RetrofitInstance
import retrofit2.Retrofit
import retrofit2.http.Query

class PhotosRepository {

    suspend fun getPhotosList(page: Int?,perPage: Int?,orderBy: String?) =
        RetrofitInstance.api.getPhotosList(page,perPage,orderBy)

    suspend fun getRandomPhoto(collectionId: String?, featured: String?, username: String?, query: String?, orientation: String?, contentFilter: String?) =
        RetrofitInstance.api.getRandomPhoto(collectionId,featured,username,query,orientation,contentFilter)
}