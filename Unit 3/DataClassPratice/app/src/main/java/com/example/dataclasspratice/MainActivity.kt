package com.example.dataclasspratice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dataclasspratice.ui.theme.DataClassPraticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DataClassPraticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CardGridDisplay()
                }
            }
        }
    }
}
@Composable
fun CardGridDisplay() {
    CardGrid(listOfTopic = DataSource().loadTopics())
}
@Composable
fun CardGrid(
    listOfTopic: List<Topic>,
    modifier: Modifier = Modifier ) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(128.dp),
        modifier = modifier
            .padding(
                top = 16.dp
            ),
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        items(listOfTopic) { topic ->
            CardTestFun(topic = topic)


        }
    }
}

@Composable
fun CardTestFun(
                topic: Topic,
                modifier: Modifier = Modifier
                ) {
    Card(modifier = modifier
        .height(68.dp)
        ) {
        Row {
            Image(
                painter = painterResource(id = topic.image) ,
                contentDescription = null,
                modifier = modifier
                    .height(68.dp)
                    .width(68.dp)
            )
            Column() {
                Text(
                    text = stringResource(id = topic.topic),
                    modifier = modifier
                        .padding(
                            top = 16.dp,
                            end = 16.dp,
                            start = 16.dp
                                )
                )
                Row (modifier = modifier
                    .padding(
                        start = 16.dp,
                        top = 8.dp)){
                    Text(text = "Icon")
                    Spacer(
                        modifier = modifier
                            .width(8.dp)
                    )
                    Text(text = topic.number.toString())
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview() {

}