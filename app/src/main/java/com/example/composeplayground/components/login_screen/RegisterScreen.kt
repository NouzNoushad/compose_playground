package com.example.composeplayground.components.login_screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun RegisterScreen(){
    val context = LocalContext.current

    var userName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var mobile by remember { mutableStateOf("") }

    var nameErrorText by remember { mutableStateOf("") }
    var emailErrorText by remember { mutableStateOf("") }
    var passwordErrorText by remember { mutableStateOf("") }
    var confirmPasswordErrorText by remember { mutableStateOf("") }
    var mobileErrorText by remember { mutableStateOf("") }

    var isNameError by remember { mutableStateOf(false) }
    var isEmailError by remember { mutableStateOf(false) }
    var isPasswordError by remember { mutableStateOf(false) }
    var isConfirmPasswordError by remember { mutableStateOf(false) }
    var isMobileError by remember { mutableStateOf(false) }
    val emailPattern = Regex("[a-zA-Z0–9._-]+@[a-z]+\\.+[a-z]+")
    val passwordPattern = Regex("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")

    val checkFormErrors = {
        if(userName.isEmpty()){
            isNameError = true
            nameErrorText = "Name field is required"
        }
        else{
            isNameError = false
            nameErrorText = ""
        }

        if(email.isEmpty()){
            isEmailError = true
            emailErrorText = "Email field is required"
        }
        else if(!emailPattern.matches(email)){
            isEmailError = true
            emailErrorText = "Invalid email"
        }
        else{
            isEmailError = false
            emailErrorText = ""
        }

        if(password.isEmpty()){
            isPasswordError = true
            passwordErrorText = "Password field is required"
        }
        else if(!passwordPattern.matches(password)){
            isPasswordError = true
            passwordErrorText = "Password must have minimum eight characters, at least one letter, one number and one special character"
        }
        else{
            isPasswordError = false
            passwordErrorText = ""
        }

        if(confirmPassword.isEmpty()){
            isConfirmPasswordError = true
            confirmPasswordErrorText = "Confirm password field is required"
        }
        else if(confirmPassword != password){
            isConfirmPasswordError = true
            confirmPasswordErrorText = "Password does not match"
        }
        else{
            isConfirmPasswordError = false
            confirmPasswordErrorText = ""
        }

        if(mobile.isEmpty()){
            isMobileError = true
            mobileErrorText = "Mobile field is required"
        }
        else if(mobile.length < 10){
            isMobileError = true
            mobileErrorText = "Invalid mobile"
        }
        else {
            isMobileError = false
            mobileErrorText = ""
        }

        if(!isNameError && !isEmailError && !isPasswordError && !isConfirmPasswordError && !isMobileError){
            Toast.makeText(context, "Successfully registered", Toast.LENGTH_SHORT).show()
        }
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(30, 30, 30))){
        LazyColumn (
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            item {
                Box(
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth()
                        .background(Color.Transparent),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "register".uppercase(),
                        style = TextStyle(
                            fontSize = 30.sp,
                            letterSpacing = 1.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(218, 219, 219)
                        )
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
                BuildTextField(
                    value = userName,
                    placeholder = "User name",
                    onValueChange = { userName = it }
                )
                if (isNameError) {
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = nameErrorText,
                        modifier = Modifier.fillMaxWidth(0.8f),
                        style = TextStyle(
                            color = Color(218, 219, 219)
                        ),
                    )
                }
                Spacer(modifier = Modifier.height(if (isNameError) 5.dp else 15.dp))
                BuildTextField(
                    value = email,
                    placeholder = "Email",
                    onValueChange = { email = it },
                    keyboardType = KeyboardType.Email
                )
                if (isEmailError) {
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = emailErrorText,
                        modifier = Modifier.fillMaxWidth(0.8f),
                        style = TextStyle(
                            color = Color(218, 219, 219)
                        ),
                    )
                }
                Spacer(modifier = Modifier.height(if (isEmailError) 5.dp else 15.dp))
                BuildTextField(
                    value = password,
                    placeholder = "Password",
                    onValueChange = { password = it },
                    keyboardType = KeyboardType.Password
                )
                if (isPasswordError) {
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = passwordErrorText,
                        modifier = Modifier.fillMaxWidth(0.8f),
                        style = TextStyle(
                            color = Color(218, 219, 219)
                        ),
                    )
                }
                Spacer(modifier = Modifier.height(if (isPasswordError) 5.dp else 15.dp))
                BuildTextField(
                    value = confirmPassword,
                    placeholder = "Confirm Password",
                    onValueChange = { confirmPassword = it },
                    keyboardType = KeyboardType.Password
                )
                if (isConfirmPasswordError) {
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = confirmPasswordErrorText,
                        modifier = Modifier.fillMaxWidth(0.8f),
                        style = TextStyle(
                            color = Color(218, 219, 219)
                        ),
                    )
                }
                Spacer(modifier = Modifier.height(if (isConfirmPasswordError) 5.dp else 15.dp))
                BuildTextField(
                    value = mobile,
                    placeholder = "Mobile",
                    onValueChange = { mobile = it },
                    keyboardType = KeyboardType.Phone
                )
                if (isMobileError) {
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = mobileErrorText,
                        modifier = Modifier.fillMaxWidth(0.8f),
                        style = TextStyle(
                            color = Color(218, 219, 219)
                        ),
                    )
                }
                Spacer(modifier = Modifier.height(if (isMobileError) 5.dp else 15.dp))
                BuildRegisterButton(
                    title = "Register",
                    color = Color(167, 105, 106),
                    onClick = checkFormErrors
                )
                Spacer(modifier = Modifier.height(40.dp))
            }
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
            style = TextStyle(fontSize = 18.sp,
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
        textStyle = TextStyle(fontSize = 18.sp,),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(62,62,62),
            focusedPlaceholderColor = Color(218,219,219),
            unfocusedContainerColor = Color(62,62,62),
            unfocusedPlaceholderColor = Color(218,219,219),
            focusedTextColor = Color(218,219,219),
            unfocusedTextColor = Color(218,219,219),
            cursorColor = Color(218,219,219),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        modifier = Modifier.fillMaxWidth(0.8f))
}