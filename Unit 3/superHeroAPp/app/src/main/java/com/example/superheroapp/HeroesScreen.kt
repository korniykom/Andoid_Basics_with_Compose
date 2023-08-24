package com.example.superheroapp

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroapp.model.Hero
import com.example.superheroapp.model.HeroRepository
import com.example.superheroapp.ui.theme.SuperHeroAppTheme

@Composable
fun HeroCard(hero: Hero, modifier: Modifier = Modifier) {
    Card(elevation = CardDefaults.cardElevation(2.dp),
        modifier = modifier
            .fillMaxWidth()) {
        Box(modifier = modifier
            .padding(16.dp)
            .height(72.dp)) {
            Row() {
                Column(verticalArrangement = Arrangement.Center) {
                    Text(text = stringResource(hero.nameRes))
                    Text(text = stringResource(hero.descriptionRes))
                }
                Spacer(modifier = modifier
                    .width(16.dp))
                Image(
                    painter = painterResource(hero.imageRes) ,
                    contentDescription = null,
                    modifier = modifier
                        .height(72.dp))
            }
        }

    }
}
@Composable
fun HeroListItem(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = modifier
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .sizeIn(minHeight = 72.dp)
                .padding(16.dp)
        ) {
            Column(
                modifier = modifier
                    .weight(1f)
            ) {
                Text(
                    text = stringResource(hero.nameRes),
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = stringResource(hero.descriptionRes),
                    style = MaterialTheme.typography.bodySmall
                )
            }
            Spacer(
                modifier = modifier
                    .width(16.dp)
            )
            Box(
                modifier = modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(8.dp))
            ) {
                Image(
                    painter = painterResource(hero.imageRes),
                    contentDescription = null,
                    alignment = Alignment.Center)
            }
        }
    }
}

@Composable
fun HeroList(
    heroes: List<Hero>,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        items(heroes) { hero ->
            HeroListItem(
                hero = hero,
                modifier =  modifier
                    .padding(vertical = 8.dp, horizontal = 16.dp))
        }
    }
}

@Preview(name = "Light mode", showBackground = true)
@Preview(name = "Dark mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun HeroPreview() {
    val hero: Hero = Hero(
        nameRes =  R.string.hero1, 
        descriptionRes = R.string.description1,
        imageRes = R.drawable.android_superhero1
    )
    SuperHeroAppTheme {
        HeroListItem(hero = hero)
    }
}
@Preview
@Composable
fun PreviewHeroList() {
    HeroList(heroes = HeroRepository.heroes)
}