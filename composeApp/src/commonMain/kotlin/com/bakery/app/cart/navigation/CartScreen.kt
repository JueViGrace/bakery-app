package com.bakery.app.cart.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

class CartScreen : Screen {

    @Composable
    override fun Content() {
        Text(text = "Your cart")
    }
}
