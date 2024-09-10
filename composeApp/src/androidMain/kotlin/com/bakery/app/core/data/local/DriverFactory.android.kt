package com.bakery.app.core.data.local

import android.content.Context
import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.bakery.app.BakeryDB

actual class DriverFactory(
    val context: Context
) {
    actual suspend fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(BakeryDB.Schema.synchronous(), context, "bakery.db")
    }
}
