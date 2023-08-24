package com.example.a30daysapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.a30daysapp.R

data class Photo(
    @DrawableRes val image: Int,
    @StringRes val description: Int,

)


    val photoStorage = listOf(
        Photo(
            image = R.drawable.photo1,
            description = R.string.Description1
        ),
        Photo(
            image = R.drawable.photo2,
            description = R.string.Description2
        ),
        Photo(
            image = R.drawable.photo3,
            description = R.string.Description3
        ),
        Photo(
            image = R.drawable.photo4,
            description = R.string.Description4
        ),
        Photo(
            image = R.drawable.photo6,
            description = R.string.Description5
        ),


    )
