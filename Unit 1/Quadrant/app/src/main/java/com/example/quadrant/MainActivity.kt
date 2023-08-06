package com.example.quadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quadrant.ui.theme.QuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposableQuadrant()
                }
            }
        }
    }
}
@Preview
@Composable
fun ComposableQuadrant() {
    Column() {
        Row(modifier = Modifier.weight(1f)) {
            Quadrant(
                title = stringResource(id = R.string.first_title),
                backgroundColor = Color(0xFFEADDFF) ,
                description = stringResource(id = R.string.first_description),
                modifier = Modifier
                    .weight(1f)
            )
            Quadrant(
                title = stringResource(id = R.string.second_title),
                backgroundColor = Color(0xFFD0BCFF) ,
                description = stringResource(id = R.string.second_description),
                modifier = Modifier
                    .weight(1f)
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            Quadrant(
                title = stringResource(id = R.string.third_title),
                backgroundColor = Color(0xFFB69DF8) ,
                description = stringResource(id = R.string.third_description),
                modifier = Modifier
                    .weight(1f)
            )
            Quadrant(
                title = stringResource(id = R.string.fourth_title),
                backgroundColor = Color(0xFFF6EDFF) ,
                description = stringResource(id = R.string.fourth_description),
                modifier = Modifier
                    .weight(1f)
            )
        }



    }


}

@Composable
fun Quadrant(title: String,
             modifier: Modifier = Modifier,
             backgroundColor: Color,
             description: String
) {
    Column(modifier = modifier
        .background(backgroundColor)
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(text = description,
            textAlign = TextAlign.Justify)
    }


}

