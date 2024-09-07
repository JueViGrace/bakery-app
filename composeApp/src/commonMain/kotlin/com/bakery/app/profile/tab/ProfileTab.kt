package com.bakery.app.profile.tab

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.bakery.app.core.presentation.navigation.Tabs
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

object ProfileTab : Tab {

    override val options: TabOptions
        @Composable
        get() {
            return TabOptions(
                index = Tabs.Profile.index,
                title = stringResource(Tabs.Profile.title),
                icon = painterResource(Tabs.Profile.icon)
            )
        }

    @Composable
    override fun Content() {
        Text(text = "Profile Tab")
    }
}
