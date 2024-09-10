package com.bakery.app.dashboard.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.bakery.app.core.presentation.navigation.NavMenuTabs
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

object DashboardTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            return TabOptions(
                index = NavMenuTabs.Dashboard.index,
                title = stringResource(NavMenuTabs.Dashboard.title),
                icon = painterResource(NavMenuTabs.Dashboard.icon)
            )
        }

    @Composable
    override fun Content() {
        Text(text = "Home Tab")
    }
}
