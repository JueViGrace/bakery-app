package com.bakery.app.core.data.local

import com.bakery.app.BakeryDB
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class DbHelper(
    private val driverFactory: DriverFactory
) {
    private var db: BakeryDB? = null

    private val mutex = Mutex()

    suspend fun <Result : Any?> withDatabase(block: (BakeryDB) -> Result): Result = mutex.withLock {
        if (db == null) {
            db = createDb()
        }

        return@withLock block(db!!)
    }

    private suspend fun createDb(): BakeryDB {
        return BakeryDB(driver = driverFactory.createDriver())
    }
}
