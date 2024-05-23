package com.example.composeproject.screens

import android.content.Intent
import android.net.Uri
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController

@Composable
fun NavigationScreen(navController: NavHostController) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BotonAtrás(navController)
            Navigation()
        }
    }
}

@Composable
fun Navigation() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Desde una aplicación Android, se puede acceder a páginas webs, mediante el navegador externo o mediante Webviews",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(15.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        BotonExterno()
        Spacer(modifier = Modifier.height(16.dp))
        BotonWebView()
    }
}

@Composable
fun BotonWebView() {
    var showWebView by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.height(600.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { showWebView = !showWebView },
            modifier = Modifier
                .clip(RoundedCornerShape(40.dp)),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green)
        ) {
            Text("Abrir WebView", color = Color.White)
        }

        if (showWebView) {
            Spacer(modifier = Modifier.height(16.dp))
            WebViewScreen(url = "https://www.iberdrola.com")
        }
    }
}

@Composable
fun WebViewScreen(url: String) {
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                webViewClient = WebViewClient()
                loadUrl(url)
            }
        },
        modifier = Modifier
            .height(400.dp)
            .padding(top = 16.dp)
    )
}

@Composable
fun BotonExterno() {
    val context = LocalContext.current

    Box(
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = {
                val url = "https://www.iberdrola.com"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                context.startActivity(intent)
            },
            modifier = Modifier
                .clip(RoundedCornerShape(40.dp)),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green)
        ) {
            Text("Abrir Navegador", color = Color.White)
        }
    }
}

