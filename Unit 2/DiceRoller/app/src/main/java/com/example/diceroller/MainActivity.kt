package com.example.diceroller

import androidx.compose.material3.Button
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceroller.ui.theme.DiceRollerTheme
import java.lang.Math.random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                DiceRollerApp()
            }
        }
    }
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(align = Alignment.Center)
) {
    var result by remember {
      mutableStateOf(1)
    }
    val imageResource = when(result) {
        1-> painterResource(id = R.drawable.dice_1)
        2-> painterResource(id = R.drawable.dice_2)
        3-> painterResource(id = R.drawable.dice_3)
        4-> painterResource(id = R.drawable.dice_4)
        5-> painterResource(id = R.drawable.dice_5)
        else -> painterResource(id = R.drawable.dice_6)
    }
    val imageDescription = when(result) {
        1-> "Number 1"
        2-> "Number 2"
        3-> "Number 3"
        4-> "Number 4"
        5-> "Number 5"
        else -> "Number 6"
    }
    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        ) { Image(

            painter = imageResource,
            contentDescription = imageDescription
        )
        Spacer(
            modifier = Modifier
                .height(16.dp)
        )
        Button(onClick = {result = (1..6).random() }) {
            Text(
                text =  stringResource(id = R.string.roll)
            )
        }
    }
}

@Preview
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage()
}