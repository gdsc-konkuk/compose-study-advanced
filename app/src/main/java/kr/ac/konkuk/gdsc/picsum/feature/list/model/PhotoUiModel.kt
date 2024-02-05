package kr.ac.konkuk.gdsc.picsum.feature.list.model

data class PhotoUiModel(
    val id: Long,
    val author: String,
    val url: String
)

val MOCK_PHOTOS = listOf(
    PhotoUiModel(
        id = 0,
        author = "누",
        url = "https://picsum.photos/id/25/5000/3333"
    ),
    PhotoUiModel(
        id = 1,
        author = "누누",
        url = "https://picsum.photos/id/25/5000/3333"
    ),
    PhotoUiModel(
        id = 2,
        author = "누누누",
        url = "https://picsum.photos/id/25/5000/3333"
    ),
    PhotoUiModel(
        id = 3,
        author = "누누누누",
        url = "https://picsum.photos/id/25/5000/3333"
    ),
    PhotoUiModel(
        id = 4,
        author = "누누누누누",
        url = "https://picsum.photos/id/25/5000/3333"
    )
)
