package com.example.composeproject.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composeproject.navigation.AppScreens

@Composable
fun ForgotPasswordScreen(navController: NavController) {

    Box(
        Modifier
            .padding(16.dp)
    ) {
        ForgotPassword(Modifier.align(Alignment.Center), navController)
    }
}

@Composable
fun ForgotPassword(modifier: Modifier, navController: NavController) {

    Column(modifier = modifier) {
        ImagenIberdrola(
            Modifier.align(Alignment.CenterHorizontally)
        )
        TextoIngrese(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(10.dp))
        EmailField()
        Spacer(modifier = Modifier.padding(4.dp))
        Spacer(modifier = Modifier.padding(70.dp))
        SendButton(Modifier.align(Alignment.CenterHorizontally), navController)
        Spacer(modifier = Modifier.padding(8.dp))
        TwoLinesWithText(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(8.dp))
        SesionButton(Modifier.align(Alignment.CenterHorizontally), navController)
    }
}

@Composable
fun TextoIngrese(modifier: Modifier) {
    Text(
        text = "Ingrese correo de recuperación",
        modifier = modifier.padding(8.dp),
        fontWeight = FontWeight.Medium
    )
}

@Composable
fun SendButton(modifier: Modifier, navController: NavController) {
    Button(
        onClick = {  /*También mandaremos correo de recuperación.*/navController.navigate(route = AppScreens.LoginScreen.route) },
        modifier = modifier
            .width(250.dp)
            .height(40.dp)
            .clip(RoundedCornerShape(40.dp)),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green)
    ) {
        Text(text = "Enviar", color = Color.White)
    }
}

@Composable
fun SesionButton(modifier: Modifier, navController: NavController) {
    Button(
        onClick = { navController.navigate(AppScreens.LoginScreen.route) },
        modifier = modifier
            .width(250.dp)
            .height(40.dp)
            .background(
                color = Color.Green,
                shape = MaterialTheme.shapes.medium
            ),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
    ) {
        Text(text = "Iniciar Sesión", fontWeight = FontWeight.Bold, color = Color.Green)
    }
}


