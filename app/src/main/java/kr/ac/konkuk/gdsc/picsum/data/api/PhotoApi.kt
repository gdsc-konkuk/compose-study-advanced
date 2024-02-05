package kr.ac.konkuk.gdsc.picsum.data.api

import kr.ac.konkuk.gdsc.picsum.data.model.PhotoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoApi {
    @GET("v2/list")
    suspend fun getPhotoList(
        @Query("page") page: Int,
        @Query("limit") limit: Int = 30
    ): List<PhotoResponse>
}
