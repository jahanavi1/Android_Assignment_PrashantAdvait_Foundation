package com.joshi.android_assignment_prashantadvait_foundation.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.joshi.android_assignment_prashantadvait_foundation.MainViewModel
import com.joshi.android_assignment_prashantadvait_foundation.view.withCoil.Screen2
import com.joshi.android_assignment_prashantadvait_foundation.view.withoutCoil.Screen1

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    val viewModel = remember { MainViewModel() }
    val images by viewModel.images.collectAsState()

    NavHost(navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("home") { HomeScreen(navController) }
        composable("screen1") { Screen1(navController, imageItems = images) }
        composable("screen2") { Screen2(navController, imageItems = images) }
    }
}


