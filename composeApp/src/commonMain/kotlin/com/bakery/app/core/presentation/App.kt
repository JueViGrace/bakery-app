package com.bakery.app.core.presentation

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import com.bakery.app.core.presentation.theme.BakeryTheme
import com.bakery.app.home.screen.HomeScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    BakeryTheme(
        darkTheme = isSystemInDarkTheme(),
        dynamicColor = true
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            Navigator(
                screen = HomeScreen()
            )
        }
    }
}
