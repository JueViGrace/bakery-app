package com.bakery.app

import android.app.Application
import com.bakery.app.core.di.androidModule
import com.bakery.app.core.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class BakeryApp : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin(
            additionalModules = listOf(androidModule)
        ) {
            androidContext(this@BakeryApp)
            androidLogger()
        }
    }
}
