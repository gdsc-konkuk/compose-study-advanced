package kr.ac.konkuk.gdsc.picsum.data.repository

import kr.ac.konkuk.gdsc.picsum.data.api.PhotoApi
import javax.inject.Inject

class PhotoRepository @Inject constructor(
    private val api: PhotoApi
) {
    suspend fun loadPhotos(page: Int) = api.getPhotoList(page = page).map { it.asDomain() }
}
