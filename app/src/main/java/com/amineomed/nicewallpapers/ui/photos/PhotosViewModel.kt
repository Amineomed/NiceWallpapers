package com.amineomed.nicewallpapers.ui.photos

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amineomed.nicewallpapers.data.models.photos.Photo
import com.amineomed.nicewallpapers.data.remote.Resource
import com.amineomed.nicewallpapers.repositories.PhotosRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class PhotosViewModel(
    private val photosRepository : PhotosRepository
) : ViewModel() {

    val randomPhotos : MutableLiveData<Resource<List<Photo>>> = MutableLiveData()
    val pageNumber = 1

    fun getRandomPhoto(collectionId: String?,
                       featured: String?,
                       username: String?,
                       query: String?,
                       orientation: String?,
                       contentFilter: String?) = viewModelScope.launch {
        randomPhotos.postValue(Resource.Loading())
        val response = photosRepository.getRandomPhoto(collectionId,featured,username,query,orientation,contentFilter)
        randomPhotos.postValue(handleResponse(response))
    }

    private fun handleResponse(response: Response<List<Photo>>) : Resource<List<Photo>> {
        if (response.isSuccessful){
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(response.message())
    }
}