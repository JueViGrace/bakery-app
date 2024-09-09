package com.bakery.app.core.presentation

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import com.bakery.app.core.di.koinConfiguration
import com.bakery.app.core.presentation.theme.BakeryTheme
import com.bakery.app.home.presentation.screen.HomeScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@Composable
@Preview
fun App() {
    KoinApplication(::koinConfiguration){
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
}
