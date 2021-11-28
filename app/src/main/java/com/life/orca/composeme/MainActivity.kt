package com.life.orca.composeme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.life.orca.composeme.ui.components.YotiButton
import com.life.orca.composeme.ui.theme.ComposeMeTheme

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
    Column(
            modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        YotiButton(text = "Compose button", onClick = { /* nothing to do here */ })
        YotiButton(text = "Compose button", enabled = false, onClick = { /* nothing to do here */ })
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeMeTheme {
        Content()
    }
}