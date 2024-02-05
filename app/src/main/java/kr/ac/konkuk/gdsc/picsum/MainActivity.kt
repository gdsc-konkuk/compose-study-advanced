package kr.ac.konkuk.gdsc.picsum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import kr.ac.konkuk.gdsc.picsum.designsystem.GDSCTheme
import kr.ac.konkuk.gdsc.picsum.feature.list.AlbumScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GDSCTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = GDSCTheme.colors.background
                ) {
                    AlbumScreen()
                }
            }
        }
    }
}
