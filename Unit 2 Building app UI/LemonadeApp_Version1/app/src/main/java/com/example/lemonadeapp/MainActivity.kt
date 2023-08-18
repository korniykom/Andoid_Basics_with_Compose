package com.example.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadePreview()
                }
            }
        }
    }
}

@Composable
fun LemonadeScreen(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)) {
    var result by remember {
        mutableStateOf(1)
    }
    var imagePainter = when(result) {
        1 -> painterResource(R.drawable.lemon_tree)
        2 -> painterResource(R.drawable.lemon_squeeze)
        3 -> painterResource(R.drawable.lemon_drink)
        else -> painterResource(R.drawable.lemon_restart)
    }
    var textFiller =  when(result) {
        1 -> stringResource(id = R.string.select_lemon)
        2 -> stringResource(id = R.string.squize_lemon)
        3 -> stringResource(id = R.string.tap_lemon)
        else -> stringResource(id = R.string.empty_glass)
    }
    Box(modifier = Modifier
        .background(Color.White)) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .background(Color.Yellow),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(id = R.string.lemonade_title),
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(24.dp),
                color = Color.Black
            )
        }
        Column(modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                             if(result >= 1 && result <= 3) {
                                 result++
                             } else {
                                 result = 1
                             }
                             },
                modifier = Modifier
                    .height(380.dp)
                    .width(380.dp),
                shape = RectangleShape) {
                Column (modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                    ){
                    Image(
                        painter = imagePainter,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()


                        )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = textFiller,
                        fontSize = 24.sp,
                        color = Color.Black,


                    )
                }
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun LemonadePreview() {
    LemonadeAppTheme {
        LemonadeScreen()
    }
}