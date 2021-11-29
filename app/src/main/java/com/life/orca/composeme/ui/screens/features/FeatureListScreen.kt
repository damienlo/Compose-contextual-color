package com.life.orca.composeme.ui.screens.features

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.life.orca.composeme.ui.components.ComposeButton
import com.life.orca.composeme.ui.theme.ComposeMeTheme

@Composable
fun FeatureListScreen(
        showYotiButtonSample: () -> Unit,
        showNavigationParam: (String) -> Unit
) {
    Column(
            modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ComposeButton(text = "Show yoti button", onClick = showYotiButtonSample)
        ComposeButton(text = "Show navigation param", onClick = { showNavigationParam("42") })
    }
}

@Preview
@Composable
fun FeatureListScreenLightPreview() {
    ComposeMeTheme {
        FeatureListScreen(
                showYotiButtonSample = { /* nothing to do here */ },
                showNavigationParam = { /* nothing to do here */ },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FeatureListScreenDarkPreview() {
    ComposeMeTheme(darkTheme = true) {
        FeatureListScreen(
                showYotiButtonSample = { /* nothing to do here */ },
                showNavigationParam = { /* nothing to do here */ },
        )
    }
}