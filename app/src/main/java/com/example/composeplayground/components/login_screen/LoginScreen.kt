package com.example.composeplayground.components.login_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun LoginScreen(){
    var userName by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    val lists = listOf("A", "B", "C")
    Box(modifier = Modifier.fillMaxSize().background(Color(30, 30, 30))){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Box(modifier = Modifier
                .fillMaxHeight(0.3f)
                .fillMaxWidth()
                .background(Color.Transparent),
                contentAlignment = Alignment.Center){
                Text(text = "welcome back".uppercase(),
                    style = TextStyle(
                        fontSize = 30.sp,
                        letterSpacing = 1.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(218,219,219)
                    )
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = "Login in".uppercase(),
                style = TextStyle(
                    fontSize = 25.sp,
                    letterSpacing = 1.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(167, 105, 106)
                )
            )
            Spacer(modifier = Modifier.height(25.dp))
            BuildTextField(
                value = userName,
                placeholder = "User name",
                onValueChange = {userName = it}
            )
            Spacer(modifier = Modifier.height(15.dp))
            BuildTextField(
                value = password,
                placeholder = "Password",
                onValueChange = {password = it},
                keyboardType = KeyboardType.Password
            )
            Spacer(modifier = Modifier.height(85.dp))
            BuildRegisterButton(
                title = "login in",
                color = Color(167, 105, 106),
                onClick = {})
            Spacer(modifier = Modifier.height(40.dp))
            Text(text = "or login using social media".uppercase(),
                style = TextStyle(
                    color = Color(218,219,219),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                )
            )
            Spacer(modifier = Modifier.height(40.dp))
            LazyRow(
                modifier = Modifier.fillMaxWidth(0.4f),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                items(lists.size) {index -> Box(modifier = Modifier
                    .height(30.dp)
                    .width(30.dp)
                    .border(
                        2.dp,
                        Color(218, 219, 219),
                        shape = RoundedCornerShape(100.dp)
                    ),
                    contentAlignment = Alignment.Center){
                    Text(text = lists[index],
                        style = TextStyle(
                            color =  Color(218,219,219),
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    )
                }}
            }
            Spacer(modifier = Modifier.height(50.dp))
        }
    }
}
