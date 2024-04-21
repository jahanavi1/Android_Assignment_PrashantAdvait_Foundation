package com.joshi.android_assignment_prashantadvait_foundation.view.withoutCoil

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import com.joshi.android_assignment_prashantadvait_foundation.R
import com.joshi.android_assignment_prashantadvait_foundation.model.data.ImageItem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen1(navController: NavController, imageItems: List<ImageItem>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Without ThirdParty loading image") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.baseline_arrow_back_24),
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {

                },
                modifier = Modifier.fillMaxWidth(),
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier.padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                ImageGrid(imageItems, LocalContext.current)
            }
        }
    )
}

@Composable
fun ImageGrid(imageUrls: List<ImageItem>, context: Context) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(imageUrls) { item ->
            ImageGridItem(item.coverageURL, context, item.title)
        }
    }
}


