package com.example.pr6_shapovalova_pr_24102.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.graphics.Color
import com.example.pr6_shapovalova_pr_24102.ui.theme.DarkColorScheme
import com.example.pr6_shapovalova_pr_24102.ui.theme.LightColorScheme

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFFFB6C1),
    secondary = Color(0xFFF8BBD0),
    tertiary = Color(0xFFEFB8C9),
    background = Color(0xFF1C1B1F),
    surface = Color(0xFF1C1B1F),
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFF173A5),
    secondary = Color(0xFFF06292),
    tertiary = Color(0xFFF1558F),
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
)

@Composable
fun Pr6_shapovalova_pr24102Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = CustomTypography,
        content = content
    )
}