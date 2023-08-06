package com.example.bussinesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bussinesscard.ui.theme.BussinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BussinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MiddlePart("Max Korniyko","Android Developer")

                }
            }
        }
    }
}

@Composable
fun MiddlePart(full_name: String, title: String) {
    Column(
        modifier = Modifier
            .background(Color(0xFFB69DF8))
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
Image(
    painter = painterResource(id = R.drawable.android_logo),
    contentDescription = null,
    Modifier
        .height(256.dp)
        .width(256.dp)
    )
    Text(
        text = full_name,
        //fontWeight = FontWeight.SemiBold,
        fontSize = 40.sp,
        color = Color.White
    )
        Text(
            text = title,
            color = Color.White,
            fontSize = 36.sp
        )
        Text(
            text = "+11 (123) 444 555 666",
            fontSize = 28.sp,
            modifier = Modifier
                .padding(top = 260.dp)
        )
        Text(
            text = "example@gmail.com",
            fontSize = 28.sp,
            modifier = Modifier
                .padding(top = 20.dp)
        )
        Text(
            text = "@AndroidDev",
            fontSize = 28.sp,
            modifier = Modifier
                .padding(top = 20.dp)
        )
    }
}


