package com.example.composeproject.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun RegisterScreen(navController: NavController) {

    Box(
        Modifier
            .padding(16.dp)
    ) {
        Register(Modifier.align(Alignment.Center), navController)
    }
}

@Composable
fun Register(modifier: Modifier, navController: NavController) {

    Column(modifier = modifier) {
        ImagenIberdrola(
            Modifier.align(Alignment.CenterHorizontally)
        )
        NewUser(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(4.dp))
        EmailField()
        Spacer(modifier = Modifier.padding(4.dp))
        PasswordField()
        Spacer(modifier = Modifier.padding(30.dp))
        LoginButton(Modifier.align(Alignment.CenterHorizontally), navController)
        Spacer(modifier = Modifier.padding(8.dp))
        TwoLinesWithText(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(8.dp))
        RegisterNewButton(Modifier.align(Alignment.CenterHorizontally))
    }
}

@Composable
fun NewUser(modifier: Modifier) {
    Text(
        text = "Nuevo Usuario",
        modifier.padding(bottom = 35.dp),
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp
    )
}

@Composable
fun RegisterNewButton(modifier: Modifier) {
    Button(
        onClick = { },
        modifier = modifier
            .width(250.dp)
            .height(40.dp)
            .background(
                color = Color.Green,
                shape = MaterialTheme.shapes.medium
            ),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
    ) {
        Text(text = "Registrarte", fontWeight = FontWeight.Bold, color = Color.Green)
    }
}


