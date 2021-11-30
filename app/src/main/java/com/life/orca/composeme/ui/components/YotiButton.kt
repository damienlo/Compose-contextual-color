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
import androidx.compose.ui.graphics.Color
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
import com.life.orca.composeme.ui.theme.buttonSecondaryBackground
import com.life.orca.composeme.ui.theme.buttonSecondaryBackgroundDisabled
import com.life.orca.composeme.ui.theme.buttonSecondaryBackgroundPressed
import com.life.orca.composeme.ui.theme.buttonSecondaryBorder
import com.life.orca.composeme.ui.theme.buttonSecondaryBorderDisabled
import com.life.orca.composeme.ui.theme.buttonSecondaryBorderPressed
import com.life.orca.composeme.ui.theme.buttonSecondaryForeground
import com.life.orca.composeme.ui.theme.buttonSecondaryForegroundDisabled
import com.life.orca.composeme.ui.theme.buttonSecondaryForegroundPressed

object YotiButton {

    @Composable
    fun Primary(
            text: String,
            onClick: () -> Unit,
            modifier: Modifier = Modifier,
            enabled: Boolean = true
    ) = InternalYotiButton(
            text = text,
            onClick = onClick,
            contextualColorConfig = YotiButtonConfig(
                    background = MaterialTheme.colors.buttonPrimaryBackground,
                    backgroundDisabled = MaterialTheme.colors.buttonPrimaryBackgroundDisabled,
                    backgroundPressed = MaterialTheme.colors.buttonPrimaryBackgroundPressed,
                    border = MaterialTheme.colors.buttonPrimaryBorder,
                    borderDisabled = MaterialTheme.colors.buttonPrimaryBorderDisabled,
                    borderPressed = MaterialTheme.colors.buttonPrimaryBorderPressed,
                    text = MaterialTheme.colors.buttonPrimaryForeground,
                    textDisabled = MaterialTheme.colors.buttonPrimaryForegroundDisabled,
                    textPressed = MaterialTheme.colors.buttonPrimaryForegroundPressed
            ), modifier = modifier,
            enabled = enabled
    )

    @Composable
    fun Secondary(
            text: String,
            onClick: () -> Unit,
            modifier: Modifier = Modifier,
            enabled: Boolean = true
    ) = InternalYotiButton(
            text = text,
            onClick = onClick,
            contextualColorConfig = YotiButtonConfig(
                    background = MaterialTheme.colors.buttonSecondaryBackground,
                    backgroundDisabled = MaterialTheme.colors.buttonSecondaryBackgroundDisabled,
                    backgroundPressed = MaterialTheme.colors.buttonSecondaryBackgroundPressed,
                    border = MaterialTheme.colors.buttonSecondaryBorder,
                    borderDisabled = MaterialTheme.colors.buttonSecondaryBorderDisabled,
                    borderPressed = MaterialTheme.colors.buttonSecondaryBorderPressed,
                    text = MaterialTheme.colors.buttonSecondaryForeground,
                    textDisabled = MaterialTheme.colors.buttonSecondaryForegroundDisabled,
                    textPressed = MaterialTheme.colors.buttonSecondaryForegroundPressed
            ), modifier = modifier,
            enabled = enabled
    )

    @Composable
    private fun InternalYotiButton(
            text: String,
            onClick: () -> Unit,
            contextualColorConfig: YotiButtonConfig,
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
                        color = when {
                            !enabled -> contextualColorConfig.borderDisabled
                            isPressed -> contextualColorConfig.backgroundPressed
                            else -> contextualColorConfig.border
                        }
                ),
                colors = ButtonDefaults.buttonColors(
                        backgroundColor = if (isPressed) contextualColorConfig.backgroundPressed else contextualColorConfig.background,
                        disabledBackgroundColor = contextualColorConfig.backgroundDisabled
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
                        !enabled -> contextualColorConfig.textDisabled
                        isPressed -> contextualColorConfig.textPressed
                        else -> contextualColorConfig.text
                    },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
            )
        }
    }

    private data class YotiButtonConfig(
            val background: Color,
            val backgroundDisabled: Color,
            val backgroundPressed: Color,
            val border: Color,
            val borderDisabled: Color,
            val borderPressed: Color,
            val text: Color,
            val textDisabled: Color,
            val textPressed: Color
    )
}

@Preview
@Composable
fun YotiButtonPrimaryLightPreview() {
    ComposeMeTheme {
        YotiButton.Primary(text = "Click me", onClick = { /* */ })
    }
}

@Preview(showBackground = true)
@Composable
fun YotiButtonPrimaryDarkPreview() {
    ComposeMeTheme(darkTheme = true) {
        YotiButton.Primary(text = "Click me", onClick = { /* */ })
    }
}


@Preview
@Composable
fun YotiButtonSecondaryLightPreview() {
    ComposeMeTheme {
        YotiButton.Secondary(text = "Click me", onClick = { /* */ })
    }
}

@Preview(showBackground = true)
@Composable
fun YotiButtonSecondaryDarkPreview() {
    ComposeMeTheme(darkTheme = true) {
        YotiButton.Secondary(text = "Click me", onClick = { /* */ })
    }
}