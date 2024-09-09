package com.bakery.app.home.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.bakery.app.core.common.Constants.tabs
import com.bakery.app.core.presentation.components.BottomTabNavigationItem
import com.bakery.app.core.presentation.components.ScaffoldComponent
import com.bakery.app.core.presentation.navigation.Tabs

actual class HomeScreen actual constructor() : Screen {

    @Composable
    actual override fun Content() {
        TabNavigator(
            tab = Tabs.Dashboard.tab
        ) {
            ScaffoldComponent(
                bottomBar = {
                    BottomAppBar(
                        actions = {
                            tabs.forEach { tab ->
                                BottomTabNavigationItem(tab.tab)
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
}
