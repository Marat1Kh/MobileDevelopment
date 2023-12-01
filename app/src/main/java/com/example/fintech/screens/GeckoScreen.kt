package com.example.fintech.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fintech.common.Constants.cryptoList
import com.example.fintech.common.Constants.currList
import com.example.fintech.components.CurrencySelector
import com.example.fintech.components.FeaturedCoinCard
import com.example.fintech.domain.repository.JsonViewModel
import com.example.fintech.navigation.AppRouter
import com.example.fintech.navigation.ButtonHandler
import com.example.fintech.navigation.Screens
import org.koin.androidx.compose.get

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun GeckoScreen() {
    val viewModel = get<JsonViewModel>()
    val conversionState = viewModel.conversion.value
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Crypto Converter", color = Color.Black) },
                backgroundColor = Color(0xFF007acc)
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .padding(horizontal = 32.dp, vertical = 24.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                FeaturedCoinCard(
                    modifier = Modifier
                        .width(150.dp)
                        .height(150.dp),
                    backgroundColor = Color.Yellow,
                    name = "Bitcoin" to "BTC",
                    percentage = 6,
                    amount = 100.04
                )
                FeaturedCoinCard(
                    modifier = Modifier
                        .width(150.dp)
                        .height(150.dp),
                    backgroundColor = Color.Yellow,
                    name = "Dogecoin" to "DOGE",
                    percentage = 118,
                    amount = 16.800
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                FeaturedCoinCard(
                    modifier = Modifier
                        .width(150.dp)
                        .height(150.dp),
                    backgroundColor = Color.Yellow,
                    name = "Ethereum" to "ETH",
                    percentage = 11,
                    amount = 0.050
                )
                FeaturedCoinCard(
                    modifier = Modifier
                        .width(150.dp)
                        .height(150.dp),
                    backgroundColor = Color.Yellow,
                    name = "USD" to "USDT",
                    percentage = 0,
                    amount = 1.0,
                    textColor = Color.Black
                )
            }
            Spacer(Modifier.height(64.dp))
            Column(
                Modifier.padding(horizontal = 32.dp),
                verticalArrangement = Arrangement.Center
            ) {
                val sendAmountText = rememberSaveable { mutableStateOf("0.686") }
                val currSelectedCurrency = rememberSaveable { mutableStateOf("NGN") }
                val currSelectedToken = rememberSaveable { mutableStateOf("ETH") }

                Text(
                    modifier = Modifier.padding(bottom = 8.dp),
                    text = "Send",
                    fontSize = 14.sp,
                    color = Color.Black
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TextField(
                        modifier = Modifier.width(150.dp),
                        value = sendAmountText.value,
                        onValueChange = { sendAmountText.value = it },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Done
                        ),
                        textStyle = TextStyle(
                            color = Color.Black,
                            fontSize = 21.sp
                        ),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.LightGray,
                            focusedIndicatorColor = Color.Blue,
                            unfocusedIndicatorColor = Color.Blue,
                            disabledIndicatorColor = Color.Blue
                        ),
                        shape = MaterialTheme.shapes.medium.copy(CornerSize(24.dp))
                    )
                    // Ensure CurrencySelector is adjusted for white background
                    CurrencySelector(initialDiff = 3, isCrypto = false) {
                        currSelectedCurrency.value = currList[it]
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Divider(
                        modifier = Modifier.width(80.dp),
                        color = Color.Black,
                    )
                    Button(
                        modifier = Modifier
                            .padding(8.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
                        onClick = {
                            viewModel.convert(
                                sendAmountText.value,
                                currSelectedCurrency.value,
                                currSelectedToken.value
                            )
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.SwapHoriz,
                            contentDescription = "Change icon",
                            tint = Color.Black
                        )
                    }
                    Divider(
                        modifier = Modifier.width(80.dp),
                        color = Color.Black,
                    )
                }
                Text(
                    modifier = Modifier.padding(bottom = 8.dp),
                    text = "Get",
                    fontSize = 14.sp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.padding(bottom = 8.dp),
                        text = conversionState.coin,
                        fontSize = 21.sp,
                        color = Color.Black
                    )

                    CurrencySelector(initialDiff = 11, isCrypto = true) {
                        currSelectedToken.value = cryptoList[it]
                    }
                }
            }
        }
    }
    ButtonHandler {
        AppRouter.navigateTo(Screens.NextScreens)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GeckoScreen()
}
