package kr.ac.konkuk.gdsc.picsum.domain.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.map
import kotlinx.coroutines.flow.map
import kr.ac.konkuk.gdsc.picsum.data.repository.PhotoRepository
import kr.ac.konkuk.gdsc.picsum.feature.list.model.PhotoUiModel
import javax.inject.Inject

class GetPhotosUseCase @Inject constructor(
    private val repository: PhotoRepository
) {
    operator fun invoke() = Pager(
        config = PagingConfig(30),
        pagingSourceFactory = { PhotoPagingSource(repository) }
    ).flow.map {
        it.map {
            PhotoUiModel(it.id, it.author, it.url)
        }
    }
}
