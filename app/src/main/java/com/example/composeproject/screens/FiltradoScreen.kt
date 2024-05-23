package com.example.composeproject.screens

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Checkbox
import androidx.compose.material.IconButton
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.composeproject.R
import com.example.composeproject.navigation.AppScreens
import java.util.Calendar

@Composable
fun FiltradoScreen(navController: NavHostController) {
    Box(
        Modifier.padding(16.dp)
    ) {
        Contenido(navController)
    }
}

@Composable
fun Contenido(navController: NavController) {
    Column {
        ImagenCerrar(navController)
        TextoFiltrar()
        Spacer(modifier = Modifier.padding(6.dp))
        TextoFecha()
        Fechas()
        Spacer(modifier = Modifier.padding(10.dp))
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.LightGray)
                .padding(top = 16.dp)
        )
        Spacer(modifier = Modifier.padding(10.dp))
        PorImporte()
        Spacer(modifier = Modifier.padding(10.dp))
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.LightGray)
                .padding(top = 16.dp)
        )
        Spacer(modifier = Modifier.padding(15.dp))
        PorEstado()
        Spacer(modifier = Modifier.padding(10.dp))
        Buttons(navController)
    }
}

@Composable
fun Buttons(navController: NavController) {
    Row {
        Button(
            onClick = { navController.navigate(route = AppScreens.FacturaListScreen.route) },
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .width(150.dp)
                .height(40.dp)
                .clip(RoundedCornerShape(40.dp)),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green)
        ) {
            Text(text = "Aceptar", color = Color.White)
        }
        Spacer(modifier = Modifier.padding(6.dp))
        Button(
            onClick = { },
            modifier = Modifier
                .width(150.dp)
                .height(40.dp)
                .clip(RoundedCornerShape(40.dp)),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray)
        ) {
            Text(text = "Eliminar filtros")
        }
    }
}

@Composable
fun PorEstado() {
    Column {
        Text(text = "Por estado", fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
        PorPagadas()
        PorAnuladas()
        PorCuota()
        PorPendientes()
        PorPlanPago()
    }
}

@Composable
fun PorPlanPago() {
    var isChecked by remember { mutableStateOf(false) }
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = isChecked, onCheckedChange = { isChecked = it })
        Text(text = "Plan de pago")
    }
}

@Composable
fun PorPendientes() {
    var isChecked by remember { mutableStateOf(false) }
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = isChecked, onCheckedChange = { isChecked = it })
        Text(text = "Pendientes de pago")
    }
}

@Composable
fun PorCuota() {
    var isChecked by remember { mutableStateOf(false) }
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = isChecked, onCheckedChange = { isChecked = it })
        Text(text = "Cuota Fija")
    }
}

@Composable
fun PorAnuladas() {
    var isChecked by remember { mutableStateOf(false) }
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = isChecked, onCheckedChange = { isChecked = it })
        Text(text = "Anuladas")
    }
}

@Composable
fun PorPagadas() {
    var isChecked by remember { mutableStateOf(false) }
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = isChecked, onCheckedChange = { isChecked = it })
        Text(text = "Pagadas")
    }
}

@Composable
fun PorImporte() {
    var sliderValue by remember { mutableStateOf(0f) }
    Column() {
        Text(text = "Por un importe", fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
        Slider(
            value = sliderValue,
            onValueChange = { sliderValue = it },
            colors = SliderDefaults.colors(
                activeTrackColor = Color.Green,
                inactiveTrackColor = Color.LightGray,
                thumbColor = Color.Green
            )
        )
    }
}

@Composable
fun Fechas() {
    val context = LocalContext.current
    var selectedDate by remember { mutableStateOf("día/mes/año") }
    var selectedDate2 by remember { mutableStateOf("día/mes/año") }

    Spacer(modifier = Modifier.padding(8.dp))
    Row() {
        Column() {
            Text(
                text = "Desde:",
                fontSize = 15.sp,
                color = Color.Gray
            )
            Button(
                onClick = {
                    val calendar = Calendar.getInstance()
                    val year = calendar.get(Calendar.YEAR)
                    val month = calendar.get(Calendar.MONTH)
                    val day = calendar.get(Calendar.DAY_OF_MONTH)
                    val datePickerDialog = DatePickerDialog(
                        context,
                        { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDay: Int ->
                            selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                        },
                        year,
                        month,
                        day
                    )
                    datePickerDialog.show()
                }, modifier = Modifier,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray)
            )
            {
                Text(text = selectedDate)
            }
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Column() {
            Text(
                text = "Hasta:",
                fontSize = 15.sp,
                color = Color.Gray
            )
            Button(
                onClick = {
                    val calendar = Calendar.getInstance()
                    val year = calendar.get(Calendar.YEAR)
                    val month = calendar.get(Calendar.MONTH)
                    val day = calendar.get(Calendar.DAY_OF_MONTH)

                    val datePickerDialog = DatePickerDialog(
                        context,
                        { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDay: Int ->
                            selectedDate2 = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                        },
                        year,
                        month,
                        day
                    )
                    datePickerDialog.show()
                }, modifier = Modifier,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray)
            )
            {
                Text(text = selectedDate2)
            }
        }
    }
}

@Composable
fun TextoFecha() {
    Text(text = "Con fecha de emisión", fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
}

@Composable
fun TextoFiltrar() {
    Text(text = "Filtrar facturas", fontSize = 35.sp, fontWeight = FontWeight.Bold)
}

@Composable
fun ImagenCerrar(navController: NavController) {
    Row() {
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = { navController.popBackStack() }) {
            Image(
                painter = painterResource(id = R.drawable.ic_close),
                contentDescription = "Imagen del botón",
                modifier = Modifier.size(35.dp)
            )
        }
    }
}
