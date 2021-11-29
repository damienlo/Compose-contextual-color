package com.life.orca.composeme.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.life.orca.composeme.ui.theme.ComposeMeTheme
import java.util.Locale

@Composable
fun ComposeButton(
        text: String,
        onClick: () -> Unit,
        modifier: Modifier = Modifier
) {
    Button(
            onClick = onClick,
            shape = MaterialTheme.shapes.medium,
            modifier = modifier
    ) {
        Text(
                text = text.uppercase(),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.button,
                color = MaterialTheme.colors.onPrimary,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview
@Composable
fun ComposeButtonLightPreview() {
    ComposeMeTheme {
        ComposeButton(text = "Click me", onClick = { /* */ })
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeButtonDarkPreview() {
    ComposeMeTheme(darkTheme = true) {
        ComposeButton(text = "Click me", onClick = { /* */ })
    }
}