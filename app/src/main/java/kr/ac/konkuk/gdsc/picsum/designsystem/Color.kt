package kr.ac.konkuk.gdsc.picsum.designsystem

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

// Purple Scale
val Blue = Color(0xFF009CEB)

// Red Scale
val Error = Color(0xFFFC4646)
val Carrot = Color(0xFFFF6F0F)
val CarrotSurface = Color(0x550FF6F0F)

// Green Scale
val Green = Color(0xFF00A05B)

// Gray Scale
val Black = Color(0xFF212121)
val White = Color(0xFFFFFFFF)
val Gray900 = Color(0xFF212124)
val Gray800 = Color(0xFF393A40)
val Gray700 = Color(0xFF4D5159)
val Gray600 = Color(0xFF868B94)
val Gray500 = Color(0xFFADB1BA)
val Gray400 = Color(0xFFD1D3D8)
val Gray300 = Color(0xFFDCDEE3)
val Gray200 = Color(0xFFEAEBEE)
val Gray100 = Color(0xFFF2F3F6)


@Stable
class GDSCColors(
    primary: Color,
    onPrimary: Color,
    secondary: Color,
    background: Color,
    onBackground: Color,
    surface: Color,
    onSurface90: Color,
    onSurface80: Color,
    onSurface70: Color,
    onSurface60: Color,
    onSurface50: Color,
    onSurface40: Color,
    onSurface30: Color,
    onSurface20: Color,
    onSurface10: Color,
    error: Color,
    onError: Color,
    isLight: Boolean
) {
    var primary by mutableStateOf(primary)
        private set
    var onPrimary by mutableStateOf(onPrimary)
        private set
    var secondary by mutableStateOf(secondary)
        private set
    var background by mutableStateOf(background)
        private set
    var onBackground by mutableStateOf(onBackground)
        private set
    var surface by mutableStateOf(surface)
        private set
    var onSurface90 by mutableStateOf(onSurface90)
        private set
    var onSurface80 by mutableStateOf(onSurface80)
        private set
    var onSurface70 by mutableStateOf(onSurface70)
        private set
    var onSurface60 by mutableStateOf(onSurface60)
        private set
    var onSurface50 by mutableStateOf(onSurface50)
        private set
    var onSurface40 by mutableStateOf(onSurface40)
        private set
    var onSurface30 by mutableStateOf(onSurface30)
        private set
    var onSurface20 by mutableStateOf(onSurface20)
        private set
    var onSurface10 by mutableStateOf(onSurface10)
        private set
    var error by mutableStateOf(error)
        private set
    var onError by mutableStateOf(onError)
        private set

    var isLight by mutableStateOf(isLight)

    fun copy(): GDSCColors = GDSCColors(
        primary,
        onPrimary,
        secondary,
        background,
        onBackground,
        surface,
        onSurface90,
        onSurface80,
        onSurface70,
        onSurface60,
        onSurface50,
        onSurface40,
        onSurface30,
        onSurface20,
        onSurface10,
        error,
        onError,
        isLight
    )

    fun update(other: GDSCColors) {
        primary = other.primary
        onPrimary = other.onPrimary
        secondary = other.secondary
        background = other.background
        onBackground = other.onBackground
        surface = other.surface
        onSurface90 = other.onSurface90
        onSurface80 = other.onSurface80
        onSurface70 = other.onSurface70
        onSurface60 = other.onSurface60
        onSurface50 = other.onSurface50
        onSurface40 = other.onSurface40
        onSurface30 = other.onSurface30
        onSurface20 = other.onSurface20
        onSurface10 = other.onSurface10
        error = other.error
        onError = other.onError
        isLight = other.isLight
    }
}

fun todoColors(
    primary: Color = Carrot,
    onPrimary: Color = White,
    secondary: Color = Green,
    background: Color = White,
    onBackground: Color = Black,
    surface: Color = CarrotSurface,
    onSurface90: Color = Gray900,
    onSurface80: Color = Gray800,
    onSurface70: Color = Gray700,
    onSurface60: Color = Gray600,
    onSurface50: Color = Gray500,
    onSurface40: Color = Gray400,
    onSurface30: Color = Gray300,
    onSurface20: Color = Gray200,
    onSurface10: Color = Gray100,
    error: Color = Error,
    onError: Color = White,
    isLight: Boolean = true
): GDSCColors {
    return GDSCColors(
        primary,
        onPrimary,
        secondary,
        background,
        onBackground,
        surface,
        onSurface90,
        onSurface80,
        onSurface70,
        onSurface60,
        onSurface50,
        onSurface40,
        onSurface30,
        onSurface20,
        onSurface10,
        error,
        onError,
        isLight
    )
}
