package com.life.orca.composeme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.life.orca.composeme.ui.screens.home.HomeScreen
import com.life.orca.composeme.ui.theme.ComposeMeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Content()
                }
            }
        }
    }
}

@Composable
fun Content() {
    Surface(color = MaterialTheme.colors.background) {
        HomeScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeMeTheme {
        Content()
    }
}