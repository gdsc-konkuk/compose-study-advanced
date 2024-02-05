package kr.ac.konkuk.gdsc.picsum.feature.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.ac.konkuk.gdsc.picsum.domain.paging.GetPhotosUseCase
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(
    private val useCase: GetPhotosUseCase
) : ViewModel() {
    val photos = useCase().cachedIn(viewModelScope)
}
