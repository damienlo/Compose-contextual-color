package com.life.orca.composeme.ui.components.wrapper

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.AbstractComposeView
import androidx.core.content.withStyledAttributes
import com.life.orca.composeme.R
import com.life.orca.composeme.ui.components.YotiButton
import com.life.orca.composeme.ui.theme.ComposeMeTheme

class YotiButtonPrimaryWrapper @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0
) : AbstractComposeView(context, attrs, defStyle) {

    var text by mutableStateOf("")
    var onClick by mutableStateOf({})

    init {
        context.withStyledAttributes(
                set = attrs,
                attrs = R.styleable.YotiButtonPrimary,
                defStyleAttr = defStyle
        ) {
            getBoolean(R.styleable.YotiButtonPrimary_android_enabled, true).let { enabled ->
                isEnabled = enabled
            }
            getString(R.styleable.YotiButtonPrimary_android_text).let { txt ->
                text = txt ?: ""
            }
        }
    }

    @Composable
    override fun Content() {
        ComposeMeTheme {
            YotiButton.Primary(
                    text = text,
                    onClick = onClick,
                    enabled = this@YotiButtonPrimaryWrapper.isEnabled
            )
        }
    }
}