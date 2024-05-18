package com.example.composeplayground.components.login_screen

import android.graphics.Canvas
import android.graphics.Paint
import android.view.RoundedCorner
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import java.util.Locale

enum class Screens {
    Welcome,
    Register,
    Login
}
sealed class NavigationItem(val route: String){
    data object WelcomeScreen: NavigationItem(Screens.Welcome.name)
    data object RegisterScreen: NavigationItem(Screens.Register.name)
    data object LoginScreen: NavigationItem(Screens.Login.name)
}
@Preview(showBackground = true)
@Composable
fun AuthRoutes(){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = NavigationItem.WelcomeScreen.route) {
        composable(NavigationItem.WelcomeScreen.route){
            WelcomeScreen(){
                navController.navigate(it)
            }
        }
        composable(NavigationItem.RegisterScreen.route){
            RegisterScreen()
        }
        composable(NavigationItem.LoginScreen.route){
            LoginScreen()
        }
    }
}

@Composable
fun WelcomeScreen(navigateTo: (route: String) -> Unit){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(30,30,30))){
        TopSection()
        Box(modifier = Modifier
            .align(Alignment.BottomCenter)
            .fillMaxHeight(0.6f)
            .fillMaxWidth()
            .background(Color.Transparent),
            contentAlignment = Alignment.Center) {
                BottomSection(navigateTo)
            }
    }
}

@Composable
fun BottomSection(navigateTo: (route: String) -> Unit) {
    val lists = listOf("A", "B", "C")
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        BuildButton(
            title = "Login in",
            color = Color(62,62,62),
            onClick = {
                navigateTo(NavigationItem.LoginScreen.route)
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        BuildButton(
            title = "Create Account",
            color = Color(167, 105, 106),
            onClick = {
                navigateTo(NavigationItem.RegisterScreen.route)
            }
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text(text = "or login using social media".uppercase(),
            style = TextStyle(
                color = Color(218,219,219),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
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
    }
}

@Composable
fun BuildButton(
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
fun TopSection() {
    Box(
        modifier = Modifier
            .fillMaxHeight(0.55f)
            .fillMaxWidth()
            .clip(CurveCut())
            .background(Color(167, 105, 106)),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Welcome".uppercase(Locale.ROOT),
            style = TextStyle(
                fontSize = 45.sp,
                fontWeight = FontWeight.Bold,
                color = Color(218,219,219),
                letterSpacing = 2.sp
            )
        )
    }
}

class CurveCut : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val w = size.width
        val h = size.height
        val path = Path().apply {
            moveTo(0f, 0f)
            lineTo(0f, h.times(0.8f))
            quadraticBezierTo(w.times(0.5f), h, w, h.times(0.8f))
            lineTo(w, 0f)
            close()
        }
        return Outline.Generic(path)
    }
}