package com.project.thyroidtestapp.thyroidTestApp.ui.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import java.sql.RowId

@Composable
fun DetailScreen(mediaId: Int){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center

    ){
        Text(
            text ="panatalla 2 $mediaId",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}