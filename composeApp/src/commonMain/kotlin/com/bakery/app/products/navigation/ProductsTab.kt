package com.bakery.app.products.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.bakery.app.core.presentation.navigation.NavMenuTabs
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

object ProductsTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            return TabOptions(
                index = NavMenuTabs.Products.index,
                title = stringResource(NavMenuTabs.Products.title),
                icon = painterResource(NavMenuTabs.Products.icon)
            )
        }

    @Composable
    override fun Content() {
        Text(text = "Products Tab")
    }
}
