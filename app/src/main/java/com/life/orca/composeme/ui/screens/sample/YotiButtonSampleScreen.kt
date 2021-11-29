package com.life.orca.composeme.ui.screens.sample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.life.orca.composeme.ui.components.YotiButton
import com.life.orca.composeme.ui.theme.ComposeMeTheme

@Composable
fun YotiButtonSampleScreen() {
    Column(
            modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
                text = "Enabled",
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.onBackground
        )
        YotiButton(text = "Compose button", onClick = { /* nothing to do here */ })
        Text(
                text = "Disabled",
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.onBackground
        )
        YotiButton(text = "Compose button", enabled = false, onClick = { /* nothing to do here */ })
    }
}

@Preview
@Composable
fun YotiButtonSampleScreenLightPreview() {
    ComposeMeTheme {
        YotiButtonSampleScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun YotiButtonSampleScreenDarkPreview() {
    ComposeMeTheme(darkTheme = true) {
        YotiButtonSampleScreen()
    }
}