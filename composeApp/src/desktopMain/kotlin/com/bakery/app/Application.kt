package com.bakery.app

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.bakery.app.core.di.desktopModule
import com.bakery.app.core.di.initKoin
import com.bakery.app.core.presentation.App

fun main() = application {
    initKoin(additionalModules = listOf(desktopModule))

    Window(
        onCloseRequest = ::exitApplication,
        title = "Bakery and Deserts",
    ) {
        App()
    }
}
