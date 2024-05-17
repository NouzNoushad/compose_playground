package com.example.composeplayground.components.login_screen

import android.graphics.Canvas
import android.graphics.Paint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
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
import java.util.Locale

@Preview(showBackground = true)
@Composable
fun WelcomeScreen(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)){
        TopSection()
        Box(modifier = Modifier
            .align(Alignment.BottomCenter)
            .fillMaxHeight(0.6f)
            .fillMaxWidth()
            .background(Color.Transparent),
            contentAlignment = Alignment.Center) {
                BottomSection()
            }
    }
}

@Composable
fun BottomSection() {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        BuildButton(
            title = "Login in",
            color = Color(62,62,62),
            onClick = {}
        )
        Spacer(modifier = Modifier.height(10.dp))
        BuildButton(
            title = "Create Account",
            color = Color(167, 105, 106),
            onClick = {}
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
            .fillMaxHeight(0.12f),
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        )
    ) {
        Text(text = title.uppercase(),
            style = TextStyle(fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
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