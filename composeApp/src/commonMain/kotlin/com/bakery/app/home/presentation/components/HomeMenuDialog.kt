package com.bakery.app.home.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import bakery_app.composeapp.generated.resources.Res
import bakery_app.composeapp.generated.resources.ic_shopping_cart_24px
import bakery_app.composeapp.generated.resources.manage_account
import bakery_app.composeapp.generated.resources.reimusandia
import bakery_app.composeapp.generated.resources.shopping_cart
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import com.bakery.app.cart.navigation.CartScreen
import com.bakery.app.core.presentation.components.CloseIconButton
import com.bakery.app.profile.navigation.ProfileTab
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun HomeMenuDialog(
    onDismissRequest: () -> Unit,
) {
    val navigator = LocalNavigator.currentOrThrow
    val tabNavigator = LocalTabNavigator.current

    Dialog(
        onDismissRequest = onDismissRequest
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(
                containerColor = CardDefaults.cardColors().containerColor.copy(alpha = 0.5f)
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CloseIconButton(
                        modifier = Modifier.padding(4.dp),
                        onClick = onDismissRequest
                    )
                }

                AccountItem {
                    onDismissRequest()
                    tabNavigator.current = ProfileTab
                }

                CartItem {
                    onDismissRequest()
                    navigator.parent?.push(CartScreen())
                }
            }
        }
    }
}

@Composable
private fun AccountItem(
    onManageClick: () -> Unit
) {
    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .background(color = Color.White, shape = CircleShape)
                        .sizeIn(maxHeight = 32.dp, maxWidth = 32.dp)
                        .clip(CircleShape)
                        .padding(2.dp),
                    painter = painterResource(Res.drawable.reimusandia),
                    contentDescription = "User picture"
                )

                Column(
                    modifier = Modifier.fillMaxWidth().weight(1f),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "User 1",
                        fontWeight = MaterialTheme.typography.bodyLarge.fontWeight,
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize
                    )
                    Text(
                        text = "user1@gmail.com",
                        fontWeight = MaterialTheme.typography.bodyMedium.fontWeight,
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize
                    )
                }
            }

            ElevatedButton(
                onClick = onManageClick,
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.primary)
            ) {
                Text(
                    text = stringResource(Res.string.manage_account),
                    fontWeight = MaterialTheme.typography.bodyMedium.fontWeight,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize
                )
            }
        }
    }
}

@Composable
private fun CartItem(
    onClick: () -> Unit
) {
    ElevatedCard(
        onClick = onClick,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.sizeIn(maxHeight = 24.dp, maxWidth = 24.dp),
                painter = painterResource(Res.drawable.ic_shopping_cart_24px),
                contentDescription = stringResource(Res.string.shopping_cart)
            )
            Text(text = stringResource(Res.string.shopping_cart))
        }
    }
}
