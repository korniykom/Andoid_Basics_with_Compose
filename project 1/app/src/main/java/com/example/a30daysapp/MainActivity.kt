package com.example.a30daysapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.UiMode
import androidx.compose.ui.unit.dp

import com.example.a30daysapp.model.Photo

import com.example.a30daysapp.model.photoStorage

import com.example.a30daysapp.ui.theme._30DaysAppTheme
import java.sql.ClientInfoStatus

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _30DaysAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_top_bar),
                style = MaterialTheme.typography.titleLarge
            )
        })
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(modifier: Modifier = Modifier) {

    Scaffold(
        topBar = {
            AppTopBar()
        }
    ){
        LazyColumn(contentPadding = it) {
            items(photoStorage) {
                CardItem(
                    photo = it,
                    )
            }
        }
    }
}

@Composable
fun CardItem(photo: Photo, modifier: Modifier = Modifier) {
    var expended by remember { mutableStateOf(true)}
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)

        ) {
        Column {

                Box(
                    modifier = modifier
                        .wrapContentHeight(),


                ) {
                    Image(
                        painter = painterResource(id = photo.image),
                        contentDescription = null,
                        modifier = modifier,
                        )

                }
                if(expended) {
                        (ClickableText
                            (
                            text = AnnotatedString(stringResource(id = photo.description)),
                            style = MaterialTheme.typography.titleLarge,
                            modifier = modifier
                                .wrapContentHeight()
                                .fillMaxWidth()
                                .animateContentSize(
                                    animationSpec = spring(
                                        dampingRatio = Spring.DampingRatioNoBouncy,
                                        stiffness = Spring.StiffnessMedium)
                                ),

                            onClick = {expended = !expended}

                            )
                        )
                }

        }

    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AppPreview( ) {
    _30DaysAppTheme {
        App()
    }
}