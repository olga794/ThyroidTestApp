package com.project.thyroidtestapp.thyroidTestApp.ui.intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.project.thyroidtestapp.R

@Composable
fun FondoIntro() {
    Image(
        painter = painterResource(id = R.drawable.fondo_intro,),
        contentDescription = "fondoIntro",
        contentScale= ContentScale.FillBounds,
        modifier = Modifier
            .fillMaxSize()
            //.requiredWidth(474.0.dp)
            //.requiredHeight(655.0.dp)
            .alpha(alpha = 0.4000000059604645f)
            .background(
                Color(
                    alpha = 255,
                    red = 103,
                    green = 82,
                    blue = 164
                )
            )


    )

}