package com.life.orca.composeme.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.life.orca.composeme.ui.theme.ComposeMeTheme
import com.life.orca.composeme.ui.theme.buttonPrimaryBackground
import com.life.orca.composeme.ui.theme.buttonPrimaryBackgroundDisabled
import com.life.orca.composeme.ui.theme.buttonPrimaryBackgroundPressed
import com.life.orca.composeme.ui.theme.buttonPrimaryBorder
import com.life.orca.composeme.ui.theme.buttonPrimaryBorderDisabled
import com.life.orca.composeme.ui.theme.buttonPrimaryBorderPressed
import com.life.orca.composeme.ui.theme.buttonPrimaryForeground
import com.life.orca.composeme.ui.theme.buttonPrimaryForegroundDisabled
import com.life.orca.composeme.ui.theme.buttonPrimaryForegroundPressed
import java.util.Locale

@Composable
fun YotiButton(
        text: String,
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        enabled: Boolean = true
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    Button(
            onClick = onClick,
            shape = MaterialTheme.shapes.medium,
            interactionSource = interactionSource,
            enabled = enabled,
            border = BorderStroke(
                    width = 2.dp,
                    color =  when {
                        !enabled -> MaterialTheme.colors.buttonPrimaryBorderDisabled
                        isPressed -> MaterialTheme.colors.buttonPrimaryBorderPressed
                        else -> MaterialTheme.colors.buttonPrimaryBorder
                    }
            ),
            colors = ButtonDefaults.buttonColors(
                    backgroundColor = if (isPressed) MaterialTheme.colors.buttonPrimaryBackgroundPressed else MaterialTheme.colors.buttonPrimaryBackground,
                    disabledBackgroundColor = MaterialTheme.colors.buttonPrimaryBackgroundDisabled
            ),
            elevation = ButtonDefaults.elevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 0.dp,
                    disabledElevation = 0.dp
            ),
            modifier = modifier.fillMaxWidth()
    ) {
        Text(
                text = text.uppercase(),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.button,
                color = when {
                    !enabled -> MaterialTheme.colors.buttonPrimaryForegroundDisabled
                    isPressed -> MaterialTheme.colors.buttonPrimaryForegroundPressed
                    else -> MaterialTheme.colors.buttonPrimaryForeground
                },
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview
@Composable
 fun YotiButtonLightPreview() {
    ComposeMeTheme {
        YotiButton(text = "Click me", onClick = { /* */ })
    }
}

@Preview(showBackground = true)
@Composable
fun YotiButtonDarkPreview() {
    ComposeMeTheme(darkTheme = true) {
        YotiButton(text = "Click me", onClick = { /* */ })
    }
}