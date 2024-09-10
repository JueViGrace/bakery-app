package com.bakery.app.orders.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.bakery.app.core.presentation.navigation.NavMenuTabs
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

object OrdersTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            return TabOptions(
                index = NavMenuTabs.Orders.index,
                title = stringResource(NavMenuTabs.Orders.title),
                icon = painterResource(NavMenuTabs.Orders.icon)
            )
        }

    @Composable
    override fun Content() {
        Text(text = "Orders Tab")
    }
}
