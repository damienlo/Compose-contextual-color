package com.life.orca.composeme.ui.screens.viewmodelhilt

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.life.orca.composeme.R
import com.life.orca.composeme.ui.components.ComposeButton
import com.life.orca.composeme.ui.theme.ComposeMeTheme

@Composable
fun SampleViewModelHiltScreen(viewModel: SampleHiltViewModel) {
    val screenState = viewModel.state
    Crossfade(targetState = screenState) { state ->
        when (state) {
            is SampleHiltState.Loading -> SampleLoadingScreen()
            is SampleHiltState.Success -> SampleSuccessScreen(data = state.data)
            is SampleHiltState.Error -> SampleErrorScreen(retryButtonClicked = { viewModel.onRetryButtonClicked() })
        }
    }
}

@Composable
private fun SampleSuccessScreen(data: String) {
    Box(
            modifier = Modifier
                    .background(MaterialTheme.colors.background)
                    .fillMaxSize()
                    .padding(16.dp),
            contentAlignment = Alignment.Center
    ) {
        Text(
                text = stringResource(id = R.string.sample_hilt_view_model_content, data),
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onBackground,
                textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun SampleLoadingScreen() {
    Box(
            modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
            contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun SampleErrorScreen(retryButtonClicked: () -> Unit) {
    Column(
            modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
                text = stringResource(id = R.string.sample_hilt_view_model_error),
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onBackground,
                textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        ComposeButton(
                text = stringResource(id = R.string.sample_hilt_view_model_error_retry_button),
                onClick = retryButtonClicked
        )
    }
}

@Preview
@Composable
fun SampleViewModelHiltScreenSuccessLightPreview() {
    ComposeMeTheme {
        SampleSuccessScreen("data")
    }
}

@Preview(showBackground = true)
@Composable
fun SampleViewModelHiltScreenSuccessDarkPreview() {
    ComposeMeTheme(darkTheme = true) {
        SampleSuccessScreen("data")
    }
}

@Preview
@Composable
fun SampleViewModelHiltScreenLoadingLightPreview() {
    ComposeMeTheme {
        SampleLoadingScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun SampleViewModelHiltScreenLoadingDarkPreview() {
    ComposeMeTheme(darkTheme = true) {
        SampleLoadingScreen()
    }
}

@Preview
@Composable
fun SampleViewModelHiltScreenErrorLightPreview() {
    ComposeMeTheme {
        SampleErrorScreen(retryButtonClicked = { /* nothing to do here */ })
    }
}

@Preview(showBackground = true)
@Composable
fun SampleViewModelHiltScreenErrorDarkPreview() {
    ComposeMeTheme(darkTheme = true) {
        SampleErrorScreen(retryButtonClicked = { /* nothing to do here */ })
    }
}