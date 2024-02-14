package kr.ac.konkuk.gdsc.picsum.domain.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kr.ac.konkuk.gdsc.picsum.data.repository.PhotoRepository
import kr.ac.konkuk.gdsc.picsum.domain.entity.Photo
import timber.log.Timber

class PhotoPagingSource(
    private val repository: PhotoRepository
) : PagingSource<Int, Photo>() {
    override fun getRefreshKey(state: PagingState<Int, Photo>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
        val page = params.key ?: 1
        val photos = runCatching {
            repository.loadPhotos(page)
        }.getOrElse { error ->
            Timber.e(error)
            return LoadResult.Error(error)
        }

        return runCatching {
            LoadResult.Page(
                data = photos,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (photos.isEmpty()) null else page + 1
            )
        }.getOrElse {
            LoadResult.Error(it)
        }
    }
}
