package com.joshi.android_assignment_prashantadvait_foundation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.joshi.android_assignment_prashantadvait_foundation.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(true) {
        delay(3000)
        navController.navigate("home") {
            popUpTo("splash") { inclusive = true }
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.splash_icon),
                contentDescription = "Splash Screen",
                modifier = Modifier.size(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Welcome to Android Assignment - 1",
                fontSize = 20.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}
