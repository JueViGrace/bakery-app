package com.bakery.app.home.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.bakery.app.core.common.Constants.tabs
import com.bakery.app.core.presentation.components.BottomTabNavigationItem
import com.bakery.app.core.presentation.components.ScaffoldComponent
import com.bakery.app.core.presentation.navigation.NavMenuTabs
import com.bakery.app.home.viewmodel.HomeViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel

actual class HomeScreen actual constructor() : Screen {

    @Composable
    actual override fun Content() {
        val viewModel = koinViewModel<HomeViewModel>()
        val state by viewModel.state.collectAsStateWithLifecycle()
        val scope = rememberCoroutineScope()
        val snackbarHostState = remember { SnackbarHostState() }

        TabNavigator(
            tab = NavMenuTabs.Dashboard.tab
        ) {
            ScaffoldComponent(
                snackbarHost = {
                    SnackbarHost(snackbarHostState)
                },
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
                LaunchedEffect(state.greetings != "") {
                    delay(300)
                    scope.launch { snackbarHostState.showSnackbar(state.greetings) }
                }
                CurrentTab()
            }
        }
    }
}
