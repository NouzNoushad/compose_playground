package com.example.composeplayground.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class Screen {
    FirstScreen,
    SecondScreen
}

sealed class NavigationItem(val route: String){
    data object FirstScreen: NavigationItem(Screen.FirstScreen.name)
    data object SecondScreen: NavigationItem(Screen.SecondScreen.name)
}

@Preview(showBackground = true)
@Composable
fun AppNavigationScreen(){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = NavigationItem.FirstScreen.route) {
        composable(NavigationItem.FirstScreen.route){
            BuildScreen(
                title = "First Screen",
                buttonTitle = "Go To Second Screen",
                bgColor = Color(255, 255, 0),
                onClick = {
                    navController.navigate(
                        NavigationItem.SecondScreen.route
                    )
                })
        }
        composable(NavigationItem.SecondScreen.route){
            BuildScreen(
                title = "Second Screen",
                buttonTitle = "Go To First Screen",
                bgColor = Color(102, 255, 153),
                onClick = {
                    navController.navigate(
                        NavigationItem.FirstScreen.route
                    )
                })
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuildScreen(
    title: String,
    buttonTitle: String,
    bgColor: Color,
    onClick: () -> Unit){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = title) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Green
                )
            )
        }
    ) {
        paddingValues ->  Box(modifier = Modifier
        .fillMaxSize()
        .background(bgColor)
            .padding(paddingValues),
            contentAlignment = Alignment.Center){
            Button(onClick = onClick) {
                Text(text = buttonTitle)
            }
    }
    }
}