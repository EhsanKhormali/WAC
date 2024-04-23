package com.ehsankhormali.wac.widgets

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun WacWebView(rawHtml:String,modifier: Modifier=Modifier){
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                settings.javaScriptEnabled = true
                webViewClient = WebViewClient()

                settings.loadWithOverviewMode = false
                settings.useWideViewPort = false
                settings.setSupportZoom(false)
                //settings.useWideViewPort=true
                settings.blockNetworkImage=false

            }
        },
        update = { webView ->
            //webView.loadUrl("https://www.ldoceonline.com/")
            webView.loadData(rawHtml, "text/html", null);
        },
        modifier = modifier
    )
}