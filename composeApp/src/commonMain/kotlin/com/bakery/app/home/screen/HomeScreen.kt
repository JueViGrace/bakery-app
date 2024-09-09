package com.bakery.app.home.screen

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

expect class HomeScreen() : Screen{
    @Composable
    override fun Content()
}
