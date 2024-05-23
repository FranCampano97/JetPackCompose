package com.example.composeproject.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.composeproject.R

@Composable
fun TabScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        BotonAtrás(navController)
        TextoSmart()
        Spacer(modifier = Modifier.padding(15.dp))
        Tabs()
    }
}

@Preview(showSystemUi = true)
@Composable
fun Tabs() {
    var tabIndex by remember { mutableStateOf(0) }

    val tabs = listOf("Mi instalación", "Energía", "Detalles")
    TabRow(
        selectedTabIndex = tabIndex, contentColor = Color.White, backgroundColor = Color.White,
    ) {
        tabs.forEachIndexed { index, title ->
            Tab(text = { Text(title, color = Color.Black) },
                selected = tabIndex == index,
                onClick = { tabIndex = index }
            )
        }
    }
    when (tabIndex) {
        0 -> InstalationScreen()
        1 -> EnergyScreen()
        2 -> DetailsScreen()
    }
}

@Composable
fun BotonAtrás(navController: NavHostController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
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
            text = "Atrás",
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Green
        )
    }
}

@Composable
fun TextoSmart() {
    Text(text = "Smart Solar", fontSize = 30.sp, fontWeight = FontWeight.Bold)
}

@Composable
fun InstalationScreen(modifier: Modifier = Modifier.fillMaxHeight()) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(25.dp))
        Text(
            text = "Aquí tienes los datos de tu instalación fotovoltaica en tiempo real",
            Modifier.padding(horizontal = 15.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            ImagenInstalacion(
                Modifier
                    .align(Alignment.Center)
            )
        }
    }
}


@Composable
fun EnergyScreen() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(30.dp))
        ImagenEnergia(
            Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 16.dp)
        )
        Spacer(modifier = Modifier.padding(20.dp))
        Text(
            text = "Estamos trabajando en mejorar la App. Tus paneles solares siguen produciendo, en breve podrás seguir viendo tu producción solar. Sentimos las molestias.",
            Modifier.padding(horizontal = 30.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun DetailsScreen() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        CAU()
        EstadoSolicitud()
        TipoAutoconsumo()
        CompensaciónExcedentes()
        Potencia()
    }
}

@Composable
fun Potencia() {
    Spacer(modifier = Modifier.padding(8.dp))
    Text(
        text = "Potencia de instalación", fontWeight = FontWeight.SemiBold,
        color = Color.LightGray
    )
    Spacer(modifier = Modifier.padding(4.dp))
    Text(text = "5kWp", fontSize = 18.sp)
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Color.Gray)
            .padding(top = 16.dp)
    )
}

@Composable
fun CompensaciónExcedentes() {
    Spacer(modifier = Modifier.padding(8.dp))
    Text(
        text = "Compensación de excedentes", fontWeight = FontWeight.SemiBold,
        color = Color.LightGray
    )
    Spacer(modifier = Modifier.padding(4.dp))
    Text(text = "Precio PVPC", fontSize = 18.sp)
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Color.Gray)
            .padding(top = 16.dp)
    )
}

@Composable
fun TipoAutoconsumo() {
    Spacer(modifier = Modifier.padding(8.dp))
    Text(
        text = "Tipo autoconsumo", fontWeight = FontWeight.SemiBold,
        color = Color.LightGray
    )
    Spacer(modifier = Modifier.padding(4.dp))
    Text(text = "Con excedentes y compensación individual-Consumo", fontSize = 18.sp)
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Color.Gray)
            .padding(top = 16.dp)
    )
}

@Composable
fun EstadoSolicitud() {
    val showDialog = remember { mutableStateOf(false) }
    Spacer(modifier = Modifier.padding(8.dp))
    Text(
        text = "Estado solicitud autoconsumidor", fontWeight = FontWeight.SemiBold,
        color = Color.LightGray
    )
    Spacer(modifier = Modifier.padding(4.dp))
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = "No hemos recibido ninguna solicitud de autoconsumo",
            fontSize = 18.sp,
            modifier = Modifier.weight(1f)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_informacion),
            contentDescription = "Información",
            modifier = Modifier
                .size(25.dp)
                .clickable { showDialog.value = true }
        )

        if (showDialog.value) {
            AlertDialog(
                modifier = Modifier.padding(horizontal = 16.dp),
                onDismissRequest = { showDialog.value = false },
                title = {
                    Text(
                        text = "Estado solicitud autoconsumo",
                        fontWeight = FontWeight.Bold
                    )
                },
                text = {
                    Text(text = "El tiempo estimado de activación de tu autoconsumo es de 1 a 2 meses, éste variará en función de tu comunidad autónoma y distribuidora")
                },
                confirmButton = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(
                            onClick = { showDialog.value = false },
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green),
                            shape = RoundedCornerShape(50),
                            modifier = Modifier.width(200.dp)
                        ) {
                            Text(text = "Aceptar", color = Color.White)
                        }
                    }
                }
            )
        }
    }
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Color.Gray)
            .padding(top = 16.dp)
    )
}

@Composable
fun CAU() {
    Spacer(modifier = Modifier.padding(8.dp))
    Text(
        text = "CAU(Código de autoconsumo)",
        fontWeight = FontWeight.SemiBold,
        color = Color.LightGray
    )
    Spacer(modifier = Modifier.padding(4.dp))
    Text(text = "ES00021000000001994LJ1FA000", fontSize = 18.sp)

    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Color.Gray)
    )
}

@Composable
fun ImagenInstalacion(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.graficoinstalacion),
        contentDescription = "Instalación",
        modifier = modifier
            .size(250.dp)
    )
}

@Composable
fun ImagenEnergia(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.imagengraf),
        contentDescription = "Instalación",
        modifier = modifier
            .size(250.dp)
    )
}