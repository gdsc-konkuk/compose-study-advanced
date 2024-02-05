package kr.ac.konkuk.gdsc.picsum.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.ac.konkuk.gdsc.picsum.domain.entity.Photo

@Serializable
data class PhotoResponse(
    @SerialName("id")
    val id: Long,
    @SerialName("author")
    val author: String,
    @SerialName("width")
    val width: Int,
    @SerialName("height")
    val height: Int,
    @SerialName("url")
    val url: String,
    @SerialName("download_url")
    val downloadUrl: String
) {
    fun asDomain() = Photo(
        id = id,
        author = author,
        url = downloadUrl
    )
}
