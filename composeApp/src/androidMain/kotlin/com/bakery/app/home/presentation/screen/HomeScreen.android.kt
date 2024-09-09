package com.bakery.app.home.presentation.screen

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.bakery.app.home.presentation.components.MobileNavigator

actual class HomeScreen actual constructor() : Screen {

    @Composable
    actual override fun Content() {
        MobileNavigator()
    }
}
