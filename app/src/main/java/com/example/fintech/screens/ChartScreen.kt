package com.example.fintech.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fintech.R
import com.example.fintech.domain.model.CryptoModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.fintech.data.remote.CryptoApi
import com.example.fintech.navigation.AppRouter
import com.example.fintech.navigation.ButtonHandler
import com.example.fintech.navigation.Screens
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ChartScreen(){
    var cryptoModels = remember { mutableStateListOf<CryptoModel>() }
    val BASE_URL = "https://raw.githubusercontent.com/"
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CryptoApi::class.java)
    val call = retrofit.getData()
    call.enqueue(object: Callback<List<CryptoModel>> {
        override fun onResponse(
            call: Call<List<CryptoModel>>,
            response: Response<List<CryptoModel>>
        ) {
            if(response.isSuccessful) {
                response.body()?.let {
                    cryptoModels.addAll(it)
                }
            }
        }

        override fun onFailure(call: Call<List<CryptoModel>>, t: Throwable) {
            t.printStackTrace()
        }
    })

    Scaffold(topBar = { AppBar() }) {
        CryptoList(cryptoList = cryptoModels)
    }
    ButtonHandler {
        AppRouter.navigateTo(Screens.NextScreens)
    }
}

@Composable
fun AppBar() {
    TopAppBar(contentPadding = PaddingValues(10.dp),
        backgroundColor = Color(0xFF007acc)
    ) {
        Text("LiveChart", fontWeight = FontWeight.Bold, fontSize = 20.sp)

    }
}

@Composable
fun CryptoList(cryptoList: List<CryptoModel>) {
    LazyColumn(contentPadding = PaddingValues(5.dp)) {
        items(cryptoList) { crypto ->
            CryptoRow(crypto = crypto)
        }
    }
}

@Composable
fun CryptoRow(crypto: CryptoModel) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable {
                Toast.makeText(
                    context,
                    "Clicked: ${crypto.currency} and current price is  ${crypto.price}",
                    Toast.LENGTH_SHORT
                ).show()
            },
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp),
    ) {
        Row(
            modifier = Modifier.size(width = 370.dp, height = 100.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
        ) {
            Column(modifier = Modifier
                .background(color = MaterialTheme.colors.onError)
                .width(200.dp)
            ) {
                Text(text = crypto.currency,
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.padding(2.dp),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = crypto.price,
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.padding(2.dp),
                )
            }
            Image(bitmap = ImageBitmap.
            imageResource(id = R.drawable.indir),
                contentDescription = "graphics",
                modifier = Modifier.requiredSize(150.dp)
            )
        }
    }
    ButtonHandler {
        AppRouter.navigateTo(Screens.NextScreens)
    }
}