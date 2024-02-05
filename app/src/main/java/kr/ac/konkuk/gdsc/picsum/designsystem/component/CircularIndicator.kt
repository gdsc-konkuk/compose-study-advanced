package kr.ac.konkuk.gdsc.picsum.designsystem.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kr.ac.konkuk.gdsc.picsum.designsystem.GDSCTheme
import kr.ac.konkuk.gdsc.picsum.designsystem.preview.ComponentPreview

@Composable
fun CircularIndicator(modifier: Modifier = Modifier) {
    CircularProgressIndicator(
        modifier = modifier.padding(16.dp),
        color = GDSCTheme.colors.primary,
        trackColor = GDSCTheme.colors.secondary.copy(alpha = 0.4f)
    )
}

@ComponentPreview
@Composable
private fun CircularIndicatorPreview() {
    GDSCTheme {
        CircularIndicator()
    }
}
