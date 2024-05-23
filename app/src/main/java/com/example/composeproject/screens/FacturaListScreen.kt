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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.composeproject.Factura
import com.example.composeproject.R
import com.example.composeproject.navigation.AppScreens

@Composable
fun FacturaListScreen(navController: NavHostController) {
    Box(
        Modifier
            .padding(16.dp)
    ) {
        ComponentesLista(modifier = Modifier.align(Alignment.CenterStart), navController)
    }
}

@Composable
fun ComponentesLista(modifier: Modifier, navController: NavHostController) {
    Column(modifier = modifier) {
        Consumo(Modifier.align(Alignment.Start), navController)
        Spacer(modifier = Modifier.padding(4.dp))
        Facturas()
        RecyclerView()
    }
}

@Composable
fun Consumo(modifier: Modifier, navController: NavController) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { navController.popBackStack() }) {
            Image(
                painter = painterResource(id = R.drawable.ic_nav_before),
                contentDescription = "Imagen del botón",
                modifier = Modifier.size(35.dp)
            )
        }
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "Consumo", fontSize = 20.sp, fontWeight = FontWeight.Medium, color = Color.Green
        )
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = { navController.navigate(AppScreens.FiltradoScreen.route) }) {
            Image(
                painter = painterResource(id = R.drawable.ajustes),
                contentDescription = "Imagen del botón",
                modifier = Modifier.size(60.dp)
            )
        }
    }
}

@Composable
fun Facturas() {
    Text(text = "Facturas", fontSize = 40.sp, fontWeight = FontWeight.Bold)
}

@Composable
fun RecyclerView() {
    val facturaItems = listOf(
        Factura("31/07/2023", "Pendiente de pago", "10.12 €"),
        Factura("15/05/2024", "Pagada", "20.45 €"),
        Factura("22/09/2023", "Pendiente de pago", "15.68 €"),
        Factura("10/11/2023", "Pagada", "25.97 €"),
        Factura("03/04/2024", "Pendiente de pago", "30.76 €"),
        Factura("12/12/2023", "Pendiente de pago", "18.48 €"),
        Factura("05/08/2024", "Pagada", "35.32 €"),
        Factura("20/10/2023", "Pendiente de pago", "22.76 €"),
        Factura("07/06/2024", "Pendiente de pago", "28.50 €"),
        Factura("18/09/2023", "Pagada", "40 €")
    )

    LazyColumn {
        items(facturaItems) { item ->
            FacturaListItem(item = item)
        }
    }
}

@Composable
fun FacturaListItem(item: Factura) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = item.concepto, fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                if (item.estado == "Pendiente de pago") {
                    Text(text = item.estado, fontSize = 16.sp, color = Color.Red)
                }
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = item.precio, fontSize = 16.sp)
                IconButton(onClick = {}) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_practica),
                        contentDescription = "Imagen del botón"
                    )
                }
            }
        }
        Spacer(modifier = Modifier.padding(4.dp))
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.Gray)
                .padding(top = 16.dp)
        )
    }
}