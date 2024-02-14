package kr.ac.konkuk.gdsc.picsum.feature.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import kotlinx.coroutines.flow.flowOf
import kr.ac.konkuk.gdsc.picsum.designsystem.GDSCTheme
import kr.ac.konkuk.gdsc.picsum.designsystem.component.CircularIndicator
import kr.ac.konkuk.gdsc.picsum.designsystem.preview.DevicePreview
import kr.ac.konkuk.gdsc.picsum.feature.list.component.PhotoCard
import kr.ac.konkuk.gdsc.picsum.feature.list.model.MOCK_PHOTOS
import kr.ac.konkuk.gdsc.picsum.feature.list.model.PhotoUiModel

@Composable
fun AlbumScreen(
    viewModel: AlbumViewModel = hiltViewModel(),
) {
    val photos = viewModel.photos.collectAsLazyPagingItems()
    AlbumScreen(photos)
}

@Composable
fun AlbumScreen(
    photos: LazyPagingItems<PhotoUiModel>
) {
    when (photos.loadState.refresh) {
        LoadState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularIndicator()
            }
        }

        is LoadState.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "로드를 하는데 에러가 발생했습니다.",
                    style = GDSCTheme.typography.medium1,
                    color = GDSCTheme.colors.error
                )
            }
        }

        is LoadState.NotLoading -> {
            LazyColumn(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(
                    count = photos.itemCount,
                    key = photos.itemKey { it.id }
                ) { index ->
                    val item = photos[index]
                    item?.let { photo ->
                        PhotoCard(photoUrl = photo.url, author = photo.author, onPress = { })
                    }
                }
                if (photos.loadState.append == LoadState.Loading) {
                    item(key = "loading indicator") {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            CircularIndicator()
                        }
                    }
                }
            }
        }
    }
}

@DevicePreview
@Composable
private fun AlbumScreenPreview() {
    val items = flowOf(PagingData.from(MOCK_PHOTOS)).collectAsLazyPagingItems()
    GDSCTheme {
        AlbumScreen(photos = items)
    }
}
