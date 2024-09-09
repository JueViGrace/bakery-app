package com.bakery.app.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import bakery_app.composeapp.generated.resources.Res
import bakery_app.composeapp.generated.resources.ic_account_circle_24px
import bakery_app.composeapp.generated.resources.reimusandia
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.bakery.app.core.common.Constants.tabs
import com.bakery.app.core.presentation.components.BottomTabNavigationItem
import com.bakery.app.core.presentation.components.DrawerTabNavigationItem
import com.bakery.app.core.presentation.components.ScaffoldComponent
import com.bakery.app.core.presentation.navigation.NavMenuTabs
import com.bakery.app.home.presentation.viewmodel.HomeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MobileNavigator() {
    TabNavigator(
        tab = NavMenuTabs.Dashboard.tab
    ) {
        MobileScreen()
    }
}

@Composable
fun MobileScreen() {
    val viewModel = koinViewModel<HomeViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    MobileScaffold(
        snackbarHostState = snackbarHostState,
        scope = scope
    ) {
        LaunchedEffect(state.greetings != "") {
            scope.launch {
                delay(300)
                snackbarHostState.showSnackbar(state.greetings)
            }
        }
        CurrentTab()
    }
}

@Composable
fun MobileScaffold(
    snackbarHostState: SnackbarHostState,
    scope: CoroutineScope,
    content: @Composable () -> Unit
) {
    val tabNavigator = LocalTabNavigator.current

    ScaffoldComponent(
        topBar = {
            if (tabNavigator.current.key == NavMenuTabs.Dashboard.tab.key) {
                MobileTopBar(snackbarHostState, scope)
            }
        },
        bottomBar = {
            MobileBottomBar()
        },
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        },
    ) {
        content()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MobileTopBar(snackbarHostState: SnackbarHostState, scope: CoroutineScope) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            navigationIcon = {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .sizeIn(maxWidth = 32.dp, minWidth = 24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier.clip(CircleShape).padding(2.dp),
                        painter = painterResource(Res.drawable.reimusandia),
                        contentDescription = "Logo"
                    )
                }
            },
            title = {},
            actions = {
                IconButton(
                    onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar("TODO: Make Account Screen")
                        }
                    }
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.ic_account_circle_24px),
                        contentDescription = "Account"
                    )
                }
            }
        )
        HorizontalDivider()
    }
}

@Composable
fun MobileBottomBar() {
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

@Composable
fun DesktopNavigator() {
    TabNavigator(
        tab = NavMenuTabs.Dashboard.tab
    ) {
        DesktopScreen()
    }
}

@Composable
fun DesktopScreen() {
    val viewModel = koinViewModel<HomeViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .sizeIn(
                                minHeight = 100.dp,
                                maxHeight = 100.dp
                            ),
                        verticalArrangement = Arrangement.spacedBy(2.dp, Alignment.CenterVertically),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            modifier = Modifier.weight(1f),
                            text = "Bakery and Deserts"
                        )
                        HorizontalDivider()
                    }

                    tabs.forEach { tab ->
                        DrawerTabNavigationItem(tab.tab) {
                            scope.launch {
                                drawerState.close()
                            }
                        }
                    }
                }
            }
        },
        drawerState = drawerState
    ) {
        DesktopScaffold(
            snackbarHostState = snackbarHostState,
            drawerState = drawerState,
            scope = scope
        ) {
            LaunchedEffect(state.greetings != "") {
                scope.launch {
                    delay(300)
                    snackbarHostState.showSnackbar(state.greetings)
                }
            }
            CurrentTab()
        }
    }
}

@Composable
fun DesktopScaffold(
    snackbarHostState: SnackbarHostState,
    drawerState: DrawerState,
    scope: CoroutineScope,
    content: @Composable () -> Unit
) {
    ScaffoldComponent(
        topBar = {
            DesktopTopBar(drawerState, scope)
        },
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        },
    ) {
        content()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DesktopTopBar(
    drawerState: DrawerState,
    scope: CoroutineScope
) {
    val tabNavigator = LocalTabNavigator.current
    CenterAlignedTopAppBar(
        title = {
            Text(text = tabNavigator.current.options.title)
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    scope.launch {
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
