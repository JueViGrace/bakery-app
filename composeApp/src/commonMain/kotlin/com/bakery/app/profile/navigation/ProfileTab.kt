package com.bakery.app.profile.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.bakery.app.core.presentation.navigation.NavMenuTabs
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

object ProfileTab : Tab {

    override val options: TabOptions
        @Composable
        get() {
            return TabOptions(
                index = NavMenuTabs.Profile.index,
                title = stringResource(NavMenuTabs.Profile.title),
                icon = painterResource(NavMenuTabs.Profile.icon)
            )
        }

    @Composable
    override fun Content() {
        Text(text = "Profile Tab")
    }
}
