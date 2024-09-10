package com.bakery.app.core.presentation.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CloseIconButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    IconButton(
        modifier = modifier.size(size = 28.dp),
        onClick = onClick
    ) {
        Icon(
            imageVector = Icons.Filled.Close,
            contentDescription = Icons.Filled.Close.name
        )
    }
}
