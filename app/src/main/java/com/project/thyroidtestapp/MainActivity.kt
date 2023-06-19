package com.project.thyroidtestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.project.thyroidtestapp.thyroidTestApp.ui.intro.IntroScreen
import com.project.thyroidtestapp.thyroidTestApp.ui.intro.IntroViewModel
import com.project.thyroidtestapp.ui.theme.ThyroidTestAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThyroidTestAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    ThyroidTestNavHost()
                }
            }
        }
    }
}

