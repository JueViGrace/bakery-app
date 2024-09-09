package com.bakery.app.home.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.bakery.app.core.common.Constants.tabs
import com.bakery.app.core.presentation.components.DrawerTabNavigationItem
import com.bakery.app.core.presentation.components.ScaffoldComponent
import com.bakery.app.core.presentation.navigation.Tabs
import kotlinx.coroutines.launch

actual class HomeScreen actual constructor() : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    actual override fun Content() {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val coroutineScope = rememberCoroutineScope()

        TabNavigator(
            tab = Tabs.Dashboard.tab
        ) { tabNavigator ->
            ModalNavigationDrawer(
                drawerContent = {
                    ModalDrawerSheet {
                        Text(text = "Bakery and Deserts")
                        HorizontalDivider()
                        tabs.forEach { tab ->
                            DrawerTabNavigationItem(tab.tab){
                                coroutineScope.launch {
                                    drawerState.close()
                                }
                            }
                        }
                    }
                },
                drawerState = drawerState
            ) {
                ScaffoldComponent(
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = {
                                Text(text = tabNavigator.current.options.title)
                            },
                            navigationIcon = {
                                IconButton(
                                    onClick = {
                                        coroutineScope.launch {
                                            drawerState.apply {
                                                if (isClosed) open() else close()
                                            }
                                        }
                                    }
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.Menu,
                                        contentDescription = Icons.Filled.Menu.name
                                    )
                                }
                            }
                        )
                    }
                ) {
                    CurrentTab()
                }
            }
        }
    }
}