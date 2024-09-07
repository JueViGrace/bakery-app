package com.bakery.app.home.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.bakery.app.core.common.Constants.tabs
import com.bakery.app.core.presentation.components.ScaffoldComponent
import com.bakery.app.core.presentation.navigation.Tabs
import org.jetbrains.compose.resources.stringResource

actual class HomeScreen actual constructor() : Screen {

    @Composable
    override fun Content() {
        TabNavigator(
            tab = Tabs.Dashboard.tab
        ) {
            ScaffoldComponent(
                bottomBar = {
                    BottomAppBar(
                        actions = {
                            tabs.forEach { tab ->
                                TabNavigationItem(tab.tab)
                            }
                        },
                        contentPadding = PaddingValues(
                            top = BottomAppBarDefaults.windowInsets.asPaddingValues()
                                .calculateTopPadding(),
                            bottom = BottomAppBarDefaults.windowInsets.asPaddingValues()
                                .calculateBottomPadding(),
                        )
                    )
                }
            ) {
                CurrentTab()
            }
        }
    }

    @Composable
    private fun RowScope.TabNavigationItem(tab: Tab) {
        val tabNavigator = LocalTabNavigator.current

        NavigationBarItem(
            selected = tabNavigator.current == tab,
            onClick = { tabNavigator.current = tab },
            icon = {
                tab.options.icon?.let { icon ->
                    Icon(painter = icon, contentDescription = tab.options.title)
                }
            },
            label = { Text(text = tab.options.title) },
            alwaysShowLabel = false
        )
    }
}
