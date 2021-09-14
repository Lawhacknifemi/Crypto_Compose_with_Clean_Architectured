package com.sherif.cryptocompose.domain.presentation.feature.coin_screen.component

import androidx.annotation.MainThread
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.sherif.cryptocompose.domain.model.Coin

@Composable
fun CoinComponent(
    coin : Coin,
    onItemClick: (Coin) -> Unit
){
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable { onItemClick(coin) },
    horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = "${coin.rank}. ${coin.name}",
        fontStyle = FontStyle.Normal,
            overflow = TextOverflow.Ellipsis,
        style = MaterialTheme.typography.body1)
        Text(text = if (coin.isActive) "active" else "Inactive",
            color = if (coin.isActive) Color.Green else Color.Red,
        fontStyle = FontStyle.Italic,
            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.End
        )
    }

    Divider()
}