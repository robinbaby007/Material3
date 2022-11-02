package com.example.material3.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorPalette = darkColorScheme(

    primary = Violet10,
    onPrimary = Violet20,
    primaryContainer = Violet30,
    onPrimaryContainer = Violet90,
    inversePrimary = Violet40,

    secondary = DarkViolet80,
    onSecondary = DarkViolet20,
    secondaryContainer = DarkViolet30,
    onSecondaryContainer = DarkViolet90,


    tertiary = Green80,
    onTertiary = Green20,
    tertiaryContainer = Green30,
    onTertiaryContainer = Violet90,

    error = Red80,
    onError = Red20,
    errorContainer = Red30,
    onErrorContainer = Red90,

    background = bg10,
    onBackground = bg90,

    surface = surface30,
    onSurface = surface80,
    inverseSurface = surface90,
    inverseOnSurface = surface10,
    surfaceVariant = surface30,
    onSurfaceVariant = surface80,
    outline = surface80

)

private val LightColorPalette = lightColorScheme(

    primary = Violet40,
    onPrimary = Color.White,
    primaryContainer = Violet90,
    onPrimaryContainer = Violet10,
    inversePrimary = Violet80,

    secondary = DarkViolet40,
    onSecondary = Color.White,
    secondaryContainer = DarkViolet90,
    onSecondaryContainer = DarkViolet10,


    tertiary = Green40,
    onTertiary =  Color.White,
    tertiaryContainer = Green90,
    onTertiaryContainer = Violet10,

    error = Red40,
    onError =  Color.White,
    errorContainer = Red90,
    onErrorContainer = Red10,

    background =  bg90,
    onBackground = bg10,

    surface = surface90,
    onSurface = surface30,
    inverseSurface = surface20,
    inverseOnSurface = surface90,
    surfaceVariant = surface90,
    onSurfaceVariant = surface30,
    outline = surface40
)

@Composable
fun Material3Theme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {

    val useDynamicColor = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
    val colors = when {
        useDynamicColor && darkTheme -> dynamicDarkColorScheme(LocalContext.current)
        useDynamicColor && !darkTheme -> dynamicLightColorScheme(LocalContext.current)
        darkTheme -> DarkColorPalette
        else -> LightColorPalette
    }



    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}