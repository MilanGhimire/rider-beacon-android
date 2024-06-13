package com.ghimiremilan.riderbeacon.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Primary,
    onPrimary = Surface_100,
    secondary = PrimaryLight,
    tertiary = White,
    surface = Surface_100,
    onSurface = PrimaryText,
    surfaceVariant = Surface_200,
    onSurfaceVariant = SecondaryText,
    background = Surface_100,
)

private val LightColorScheme = lightColorScheme(
    primary = Primary,
    onPrimary = Surface_100,
    secondary = PrimaryLight,
    tertiary = White,
    surface = Surface_100,
    onSurface = PrimaryText,
    surfaceVariant = Surface_200,
    onSurfaceVariant = SecondaryText,
    background = Surface_100
)

@Composable
fun RiderBeaconTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content,
    )
}