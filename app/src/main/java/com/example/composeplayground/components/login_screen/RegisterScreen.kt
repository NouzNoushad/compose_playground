package com.example.composeplayground.components.login_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun RegisterScreen(){
    var userName by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var confirmPassword by remember {
        mutableStateOf("")
    }
    var mobile by remember {
        mutableStateOf("")
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(30, 30, 30))){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Box(modifier = Modifier
                .fillMaxHeight(0.3f)
                .fillMaxWidth()
                .background(Color.Transparent),
                contentAlignment = Alignment.Center){
                Text(text = "register".uppercase(),
                    style = TextStyle(
                        fontSize = 30.sp,
                        letterSpacing = 1.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(218,219,219)
                    )
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            BuildTextField(
                value = userName,
                placeholder = "User name",
                onValueChange = {userName = it}
                )
            Spacer(modifier = Modifier.height(15.dp))
            BuildTextField(
                value = email,
                placeholder = "Email",
                onValueChange = {email = it},
                keyboardType = KeyboardType.Email
            )
            Spacer(modifier = Modifier.height(15.dp))
            BuildTextField(
                value = password,
                placeholder = "Password",
                onValueChange = {password = it},
                keyboardType = KeyboardType.Password
            )
            Spacer(modifier = Modifier.height(15.dp))
            BuildTextField(
                value = confirmPassword,
                placeholder = "Confirm Password",
                onValueChange = {confirmPassword = it},
                keyboardType = KeyboardType.Password
            )
            Spacer(modifier = Modifier.height(15.dp))
            BuildTextField(
                value = mobile,
                placeholder = "Mobile",
                onValueChange = {mobile = it},
                keyboardType = KeyboardType.Phone
            )
            Spacer(modifier = Modifier.height(15.dp))
            BuildRegisterButton(
                title = "Register",
                color = Color(167, 105, 106),
                onClick = {})
        }
    }
}

@Composable
fun BuildRegisterButton(
    title: String,
    color: Color,
    onClick: () -> Unit
){
    Button(onClick = onClick,
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(60.dp),
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        )
    ) {
        Text(text = title.uppercase(),
            style = TextStyle(fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp,
                color = Color(218,219,219),
            )
        )
    }
}

@Composable
fun BuildTextField(
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text
    ){
    TextField(value = value,
        onValueChange = onValueChange,
        placeholder = { Text(text = placeholder.uppercase())},
        textStyle = TextStyle(fontSize = 18.sp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(62,62,62),
            focusedPlaceholderColor = Color(218,219,219),
            unfocusedContainerColor = Color(62,62,62),
            unfocusedPlaceholderColor = Color(218,219,219),
            focusedTextColor = Color(218,219,219),
            unfocusedTextColor = Color(218,219,219),
            cursorColor = Color(218,219,219),
        ),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        modifier = Modifier.fillMaxWidth(0.8f))
}