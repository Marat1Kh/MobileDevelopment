package com.example.fintech.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fintech.common.Constants.cryptoList
import com.example.fintech.common.Constants.currList

@Composable
fun CurrencySelector(initialDiff: Int = 0, isCrypto: Boolean, onValueChange: (Int) -> Unit) {
    val expanded = remember { mutableStateOf(false) }
    var init by remember { mutableStateOf(initialDiff) }
    val currentList = if (isCrypto) cryptoList else currList
    Box {
        Row(
            modifier = Modifier
                .clickable(onClick = { expanded.value = true })
        ) {
            Icon(
                modifier = Modifier
                    .padding(end = 8.dp),
                imageVector = Icons.Filled.ExpandMore,
                contentDescription = "expand",
                tint = Color.DarkGray
            )
            Text(
                modifier = Modifier
                    .padding(bottom = 8.dp),
                text = currentList[init],
                fontSize = 21.sp,
                color = Color.DarkGray
            )
        }
        DropdownMenu(
            expanded = expanded.value,
            onDismissRequest = { expanded.value = false }
        ) {
            currentList.forEachIndexed { index, s ->
                DropdownMenuItem(
                    onClick = {
                        expanded.value = false
                        init = index
                        onValueChange(index)
                    }) {
                    Text(text = s)
                }
            }
        }
    }
}