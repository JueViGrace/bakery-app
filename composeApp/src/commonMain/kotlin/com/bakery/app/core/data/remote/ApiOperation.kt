package com.bakery.app.core.data.remote

import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

sealed interface ApiOperation<out T> {
    data class Success<T>(val data: T) : ApiOperation<T>
    data class Failure(
        val status: Int = 500,
        val description: String = "Internal server error",
        val time: String = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).toString(),
        val message: String? = null,
        val error: String? = "Unknown error",
        val path: String? = null,
    ) : ApiOperation<Nothing>
}
