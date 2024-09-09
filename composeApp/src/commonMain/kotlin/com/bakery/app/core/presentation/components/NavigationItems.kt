package com.bakery.app.core.presentation.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab

@Composable
fun DrawerTabNavigationItem(tab: Tab, onSelect: () -> Unit) {
    val tabNavigator = LocalTabNavigator.current

    NavigationDrawerItem(
        selected = tabNavigator.current == tab,
        onClick = {
            tabNavigator.current = tab
            onSelect()
        },
        icon = {
            tab.options.icon?.let { icon ->
                Icon(painter = icon, contentDescription = tab.options.title)
            }
        },
        label = { Text(text = tab.options.title) },
    )
}

@Composable
fun RowScope.BottomTabNavigationItem(tab: Tab) {
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
