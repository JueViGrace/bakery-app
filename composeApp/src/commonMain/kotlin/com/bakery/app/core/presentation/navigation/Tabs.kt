package com.bakery.app.core.presentation.navigation

import bakery_app.composeapp.generated.resources.Res
import bakery_app.composeapp.generated.resources.dashboard
import bakery_app.composeapp.generated.resources.ic_account_circle_24px
import bakery_app.composeapp.generated.resources.ic_home_app_logo_24px
import bakery_app.composeapp.generated.resources.profile
import cafe.adriel.voyager.navigator.tab.Tab
import com.bakery.app.dashboard.tab.DashboardTab
import com.bakery.app.profile.tab.ProfileTab
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

sealed class Tabs(val tab: Tab, val index: UShort, val title: StringResource, val icon: DrawableResource) {
    data object Dashboard : Tabs(
        tab = DashboardTab,
        index = 0u,
        title = Res.string.dashboard,
        icon = Res.drawable.ic_home_app_logo_24px
    )

    data object Profile : Tabs(
        tab = ProfileTab,
        index = 1u,
        title = Res.string.profile,
        icon = Res.drawable.ic_account_circle_24px
    )
}
