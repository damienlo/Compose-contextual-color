package com.life.orca.composeme.ui.screens.navigationparam

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.life.orca.composeme.R
import com.life.orca.composeme.ui.theme.ComposeMeTheme

@Composable
fun NavigationParamScreen(itemId: String) {
    Column(
            modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
    ) {
        Text(
                text = stringResource(id = R.string.navigation_param_title),
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.onBackground
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
                text = stringResource(id = R.string.navigation_param_content, itemId),
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onBackground
        )
    }
}

@Preview
@Composable
fun NavigationParamScreenLightPreview() {
    ComposeMeTheme {
        NavigationParamScreen(itemId = "42")
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationParamScreenDarkPreview() {
    ComposeMeTheme(darkTheme = true) {
        NavigationParamScreen(itemId = "42")
    }
}