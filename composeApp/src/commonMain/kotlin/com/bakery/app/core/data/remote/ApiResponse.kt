package com.bakery.app.core.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse<T>(
    val status: Int,
    val description: String,
    val body: T? = null,
    val message: String? = null,
    val time: String? = null,
    val error: String? = null,
    val path: String? = null,
)
