package kr.ac.konkuk.gdsc.picsum.feature.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kr.ac.konkuk.gdsc.picsum.designsystem.GDSCTheme
import kr.ac.konkuk.gdsc.picsum.designsystem.preview.DevicePreview
import kr.ac.konkuk.gdsc.picsum.feature.list.component.PhotoCard
import kr.ac.konkuk.gdsc.picsum.feature.list.model.MOCK_PHOTOS
import kr.ac.konkuk.gdsc.picsum.feature.list.model.PhotoUiModel

@Composable
fun AlbumScreen(
    photos: ImmutableList<PhotoUiModel>
) {
    LazyColumn(
        modifier = Modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(photos.size) { index ->
            val item = photos[index]
            PhotoCard(photoUrl = item.url, author = item.author, onPress = { })
        }
    }
}

@DevicePreview
@Composable
private fun AlbumScreenPreview() {
    GDSCTheme {
        AlbumScreen(
            photos = MOCK_PHOTOS.toImmutableList()
        )
    }
}
