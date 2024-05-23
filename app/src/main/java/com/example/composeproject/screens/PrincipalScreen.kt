package com.example.composeproject.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.IconButton
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.composeproject.R
import com.example.composeproject.navigation.AppScreens

@Composable
fun PrincipalScreen(navController: NavHostController) {
    Box(
        Modifier
            .padding(16.dp)
    ) {
        Componentes(modifier = Modifier.align(Alignment.Center), navController)
    }
}

@Composable
fun Componentes(modifier: Modifier, navController: NavHostController) {
    Column(modifier = modifier) {
        PracticasAndroid()
        Spacer(modifier = Modifier.padding(4.dp))
        Práctica1(Modifier.align(Alignment.End), navController)
        Spacer(modifier = Modifier.padding(10.dp))
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.Gray)
                .padding(top = 16.dp)
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Práctica2(Modifier.align(Alignment.End),navController)
        Spacer(modifier = Modifier.padding(10.dp))
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.Gray)
                .padding(top = 16.dp)
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Navegación(Modifier.align(Alignment.End),navController)
        Spacer(modifier = Modifier.padding(10.dp))
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.Gray)
                .padding(top = 16.dp)
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Mock(Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.padding(10.dp))
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.Gray)
                .padding(top = 16.dp)
        )
    }
}

@Composable
fun Práctica1(modifier: Modifier, navController: NavHostController) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Práctica 1", fontSize = 18.sp, fontWeight = FontWeight.Medium)
        Box(
            modifier = modifier
                .size(24.dp)
        ) {
            IconButton(onClick = { navController.navigate(route = AppScreens.FacturaListScreen.route) }) {
                Image(
                    painter = painterResource(id = R.drawable.ic_practica),
                    contentDescription = "Imagen del botón",
                    modifier = modifier.size(24.dp)
                )
            }
        }
    }
}

@Composable
fun Práctica2(modifier: Modifier, navController: NavHostController) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Práctica 2", fontSize = 18.sp, fontWeight = FontWeight.Medium)
        Box(
            modifier = modifier
                .size(24.dp)
        ) {
            IconButton(onClick = {navController.navigate(AppScreens.TabScreen.route)}) {
                Image(
                    painter = painterResource(id = R.drawable.ic_practica),
                    contentDescription = "Imagen del botón",
                    modifier = modifier.size(24.dp)
                )
            }
        }
    }
}

@Composable
fun Navegación(modifier: Modifier, navController: NavHostController) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Navegación", fontSize = 18.sp, fontWeight = FontWeight.Medium)
        Box(
            modifier = modifier
                .size(24.dp)
        ) {
            IconButton(onClick = {navController.navigate(AppScreens.NavigationScreen.route)}) {
                Image(
                    painter = painterResource(id = R.drawable.ic_practica),
                    contentDescription = "Imagen del botón",
                    modifier = modifier.size(24.dp)
                )
            }
        }
    }
}

@Composable
fun Mock(modifier: Modifier) {
    var isChecked by remember {
        mutableStateOf(false)
    }
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Activar Mock", fontSize = 18.sp, fontWeight = FontWeight.Medium)
        Box(
            modifier = modifier
                .size(24.dp)
        ) {
            Switch(
                checked = isChecked, onCheckedChange = { isChecked = it },
                colors = SwitchDefaults.colors(checkedThumbColor = Color.Green)
            )
        }
    }
}

@Composable
fun PracticasAndroid() {
    Text(
        text = "Prácticas Android",
        fontSize = 25.sp, fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(vertical = 16.dp)
    )
}

