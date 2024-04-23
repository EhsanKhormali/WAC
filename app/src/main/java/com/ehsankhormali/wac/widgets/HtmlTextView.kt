package com.ehsankhormali.wac.widgets

import android.widget.TextView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat

@Composable
fun HtmlTextView(text: String,textSize:Float,modifier: Modifier) {
    AndroidView(factory = { context ->
        TextView(context).apply {
            setText(HtmlCompat.fromHtml(text,
                HtmlCompat.FROM_HTML_OPTION_USE_CSS_COLORS
                    + HtmlCompat.FROM_HTML_MODE_COMPACT
                    + HtmlCompat.FROM_HTML_SEPARATOR_LINE_BREAK_BLOCKQUOTE
                    + HtmlCompat.FROM_HTML_SEPARATOR_LINE_BREAK_PARAGRAPH
                    + HtmlCompat.FROM_HTML_SEPARATOR_LINE_BREAK_DIV
                    + HtmlCompat.FROM_HTML_SEPARATOR_LINE_BREAK_LIST
                    + HtmlCompat.FROM_HTML_SEPARATOR_LINE_BREAK_HEADING
                    + HtmlCompat.FROM_HTML_SEPARATOR_LINE_BREAK_LIST_ITEM
            ))
            setTextSize(textSize)
        }
    },
        modifier = modifier
    )
}