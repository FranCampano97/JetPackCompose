package com.example.composeproject.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Checkbox
import androidx.compose.material.Divider
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composeproject.R
import com.example.composeproject.navigation.AppScreens

@Composable
fun LoginScreen(navController: NavController) {

    Box(
        Modifier
            .padding(15.dp)
    ) {
        Login(Modifier.align(Alignment.Center), navController)
    }
}

@Composable
fun Login(modifier: Modifier, navController: NavController) {

    Column(modifier = modifier) {
        ImagenIberdrola(
            Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.padding(4.dp))
        EmailField()
        Spacer(modifier = Modifier.padding(4.dp))
        PasswordField()
        Spacer(modifier = Modifier.padding(8.dp))
        RememberPasswordCheckbox()
        ForgotPassword(navController)
        Spacer(modifier = Modifier.padding(30.dp))
        LoginButton(Modifier.align(Alignment.CenterHorizontally), navController)
        Spacer(modifier = Modifier.padding(8.dp))
        TwoLinesWithText(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(8.dp))
        RegisterButton(Modifier.align(Alignment.CenterHorizontally), navController)
    }
}

@Composable
fun RegisterButton(modifier: Modifier, navController: NavController) {
    Button(
        onClick = { navController.navigate(AppScreens.RegisterScreen.route) },
        modifier = modifier
            .width(250.dp)
            .height(40.dp),
        border = BorderStroke(3.dp, Color.Green),
        shape = RoundedCornerShape(40.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
    ) {
        Text(text = "Registrarte", fontWeight = FontWeight.Bold, color = Color.Green)
    }
}

@Composable
fun TwoLinesWithText(modifier: Modifier) {
    Row(
        modifier = modifier
    ) {
        Divider(color = Color.Black, thickness = 1.dp, modifier = modifier.width(60.dp))
        Text(
            text = "También puedes",
            color = Color.DarkGray,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Divider(color = Color.Black, thickness = 1.dp, modifier = modifier.width(60.dp))

    }
}


@Composable
fun LoginButton(modifier: Modifier, navController: NavController) {
    Button(
        onClick = { navController.navigate(route = AppScreens.PrincipalScreen.route) },
        modifier = modifier
            .width(250.dp)
            .height(40.dp)
            .clip(RoundedCornerShape(40.dp)),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green)
    ) {
        Text(text = "Entrar", color = Color.White)
    }
}

@Composable
fun RememberPasswordCheckbox() {
    var isChecked by remember { mutableStateOf(false) }
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = isChecked, onCheckedChange = { isChecked = it })
        Text(text = "Recordar contraseña", fontWeight = FontWeight.Medium)
    }
}

@Composable
fun ForgotPassword(navController: NavController) {
    Text(
        text = "He olvidado mis datos",
        modifier = Modifier
            .clickable { navController.navigate(AppScreens.ForgotPasswordScreen.route) },
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        style = TextStyle(textDecoration = TextDecoration.Underline)
    )
}

@Composable
fun PasswordField() {
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        TextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            placeholder = { Text(text = "Contraseña") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            singleLine = true,
            maxLines = 1,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val imagePainter: Painter =
                    painterResource(id = if (passwordVisible) R.drawable.ic_ojo else R.drawable.ic_ojo)

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Image(
                        painter = imagePainter,
                        contentDescription = null
                    )
                }
            },
            textStyle = TextStyle(color = Color.Black),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                placeholderColor = Color.Gray,
                textColor = Color.Black
            )
        )
        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth()
        )
    }
}

@Composable
fun EmailField() {
    var email by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        TextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            placeholder = { Text(text = "Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            singleLine = true,
            maxLines = 1,
            textStyle = TextStyle(color = Color.Black),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                placeholderColor = Color.Gray,
                textColor = Color.Black
            )
        )
        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth()
        )
    }
}

@Composable
fun ImagenIberdrola(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ic_iberdrola),
        contentDescription = "iberdrola",
        modifier = modifier
            .size(250.dp)
    )
}

