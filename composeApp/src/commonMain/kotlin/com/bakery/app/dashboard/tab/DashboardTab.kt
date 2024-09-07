package com.bakery.app.dashboard.tab

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.bakery.app.core.presentation.navigation.Tabs
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

object DashboardTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            return TabOptions(
                index = Tabs.Dashboard.index,
                title = stringResource(Tabs.Dashboard.title),
                icon = painterResource(Tabs.Dashboard.icon)
            )
        }

    @Composable
    override fun Content() {
        Text(text = "Home Tab")
    }
}
