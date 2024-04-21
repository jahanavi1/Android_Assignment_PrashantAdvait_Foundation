package com.joshi.android_assignment_prashantadvait_foundation.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(
            onClick = { navController.navigate("screen1") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text("Without ThirdParty", fontSize = 18.sp)
        }

        Button(
            onClick = { navController.navigate("screen2") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text("With ThirdParty", fontSize = 18.sp)
        }
    }
}
