package com.bakery.app

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import com.bakery.app.core.di.initKoin
import com.bakery.app.core.di.jsModule
import com.bakery.app.core.presentation.App
import org.jetbrains.skiko.wasm.onWasmReady

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    initKoin(additionalModules = listOf(jsModule))

    onWasmReady {
        CanvasBasedWindow(title = "Bakery and Deserts") {
            App()
        }
    }
}
