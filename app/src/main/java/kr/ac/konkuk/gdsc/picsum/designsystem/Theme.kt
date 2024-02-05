package kr.ac.konkuk.gdsc.picsum.designsystem

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf

private val LocalGDSCColors = staticCompositionLocalOf<GDSCColors> {
    error("No PicomposeColors provided")
}
private val LocalGDSCTypography = staticCompositionLocalOf<GDSCTypography> {
    error("No PicomposeTypography provided")
}

object GDSCTheme {
    val colors: GDSCColors
        @Composable
        @ReadOnlyComposable
        get() = LocalGDSCColors.current
    val typography: GDSCTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalGDSCTypography.current
}

@Composable
fun ProvideGDSCColorAndTypography(
    colors: GDSCColors,
    typography: GDSCTypography,
    content: @Composable () -> Unit
) {
    val provideColors = remember { colors.copy() }
    provideColors.update(colors)
    val provideTypography = remember { typography.copy() }
    provideTypography.update(typography)
    CompositionLocalProvider(
        LocalGDSCColors provides provideColors,
        LocalGDSCTypography provides provideTypography,
        content = content
    )
}

@Composable
fun GDSCTheme(darkTheme: Boolean = false, content: @Composable () -> Unit) {
    val colors = todoColors()
    val typography = GDSCTypography()
    ProvideGDSCColorAndTypography(colors, typography) {
        MaterialTheme(content = content)
    }
}
