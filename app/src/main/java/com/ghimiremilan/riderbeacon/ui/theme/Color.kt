package com.ghimiremilan.riderbeacon.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance

val Primary = Color(0xFF007041)
val PrimaryLight = Color(0xFFEEFBF6)
val PrimaryLighter = Color(0xFFF5F9F8)

val Accent = Color(0xFFF09D51)
val AccentLight = Color(0xFFF6E8DF)
val AccentLighter = Color(0xFFFEF7F1)

val Success = Color(0xFF679436)
val SuccessLight = Color(0xFFDBE5CF)
val SuccessLighter = Color(0xFFF3FAEF)

val Info = Color(0xFF2D7DD2)
val InfoLight = Color(0xFFCDE0F4)
val InfoLighter = Color(0xFFEEF5FB)

val Danger = Color(0xFFE94F4F)
val DangerLight = Color(0xFFFADBDB)
val DangerLighter = Color(0xFFFDEDED)

val Warning = Color(0xFFFF9500)
val WarningLight = Color(0xFFFFEED6)
val WarningLighter = Color(0xFFFFF7EB)

val White = Color(0xFFFFFFFF)
val Black = Color(0xFF000000)

val Gray_500 = Color(0xFF121212)
val Gray_400 = Color(0xFF555555)
val Gray_300 = Color(0xFF8A8A8E)
val Gray_200 = Color(0xFFAAAAAA)
val Gray_100 = Color(0xFFCDCDCD)

val Border = Color(0xFFEAEAEA)
val BG_2 = Color(0xFFF1F2F2)
val CardBorder = Color(0x10000000)
val DialogBackgroundColor = Color(0x3D121212)

val ChartTeal = Color(0xFF21C0B8)

val ShimmerColor1 = Color(0xFFEAEAEA)
val ShimmerColor2 = Color(0xFFF6F6F6)
val ShimmerColor3 = Color(0xFFEAEAEA)

val Surface_100 = Color(0xFFFFFFFF)
val Surface_200 = Color(0xFFFDFDFF)

val PrimaryText = Color(0xFF121212)
val SecondaryText = Color(0xFF555555)

val ChartColor1 = Color(0xFF2178C0)
val ChartColor2 = Color(0xFFF96950)
val ChartColor3 = Color(0xFF21C0B8)
val ChartColor4 = Color(0xFF767AFB)
val ChartColor5 = Color(0xFFBD7EBE)
val ChartColor6 = Color(0xFF8BD3C7)
val ChartColor7 = Color(0xFFBEB9DB)
val ChartColor8 = Color(0xFFAB3DA9)
val ChartDefaultColor = Color(0xFFA4A2A8)

val DisabledColor = Color(0xFFCDCDCD)

val IconColor = Color(0xFFF09D51)

/** Success color */
@get:Composable
private val ColorScheme.TextVariable3Dark: Color
    get() = Gray_300

@get:Composable
private val ColorScheme.TextVariable3: Color
    get() = Gray_300

@Composable
fun textVariant3(): Color {
    return if (isLightTheme()) {
        MaterialTheme.colorScheme.TextVariable3
    } else {
        MaterialTheme.colorScheme.TextVariable3Dark
    }
}

@Composable
private fun ColorScheme.isLight() = this.background.luminance() > 0.5

@Composable
fun isLightTheme() = MaterialTheme.colorScheme.isLight()