package com.life.orca.composeme.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.life.orca.composeme.R

private val DarkColorPalette = darkColors(
        primary = Purple200,
        primaryVariant = Purple700,
        secondary = Teal200
)

private val LightColorPalette = lightColors(
        primary = Purple500,
        primaryVariant = Purple700,
        secondary = Teal200

        /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

// Contained Buttons
val Colors.buttonPrimaryForeground: Color
    @Composable
    get() = colorResource(id = R.color.button_primary_foreground)
val Colors.buttonPrimaryBackground: Color
    @Composable
    get() = colorResource(id = R.color.button_primary_background)
val Colors.buttonPrimaryBorder: Color
    @Composable
    get() = colorResource(id = R.color.button_primary_border)
val Colors.buttonPrimaryBorderPressed: Color
    @Composable
    get() = colorResource(id = R.color.button_primary_border_pressed)
val Colors.buttonPrimaryForegroundPressed: Color
    @Composable
    get() = colorResource(id = R.color.button_primary_foreground_pressed)
val Colors.buttonPrimaryBackgroundPressed: Color
    @Composable
    get() = colorResource(id = R.color.button_primary_background_pressed)
val Colors.buttonPrimaryForegroundDisabled: Color
    @Composable
    get() = colorResource(id = R.color.button_primary_foreground_disabled)
val Colors.buttonPrimaryBackgroundDisabled: Color
    @Composable
    get() = colorResource(id = R.color.button_primary_background_disabled)
val Colors.buttonPrimaryBorderDisabled: Color
    @Composable
    get() = colorResource(id = R.color.button_primary_border_disabled)
val Colors.buttonPrimaryRipple: Color
    @Composable
    get() = colorResource(id = R.color.button_primary_ripple)

@Composable
fun ComposeMeTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
    )
}