package com.example.fintech.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fintech.navigation.AppRouter
import com.example.fintech.navigation.Screens

@Composable
fun NextScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Hey, there!",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(top = 24.dp, bottom = 32.dp) // Adjust padding as needed
            )
            // Define a consistent button style
            val buttonModifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .height(50.dp)  // Fixed height for all buttons

            val buttonColors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF007BFF))
            val buttonShape = RoundedCornerShape(20.dp)  // More rounded corners

            Button(
                onClick = { AppRouter.navigateTo(Screens.HomeScreens) },
                colors = buttonColors,
                modifier = buttonModifier,
                shape = buttonShape
            ) {
                Text(
                    "Crypto encyclopedia",
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
            }
            Button(
                onClick = { AppRouter.navigateTo(Screens.GeckoScreens) },
                colors = buttonColors,
                modifier = buttonModifier,
                shape = buttonShape
            ) {
                Text(
                    "Crypto Converter",
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
            }
            Button(
                onClick = { AppRouter.navigateTo(Screens.ChartScreens) },
                colors = buttonColors,
                modifier = buttonModifier,
                shape = buttonShape
            ) {
                Text(
                    "Crypto Chart's",
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun NextScreenPreview() {
    NextScreen()
}