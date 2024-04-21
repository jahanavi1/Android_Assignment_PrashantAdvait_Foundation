package com.joshi.android_assignment_prashantadvait_foundation.view.withCoil

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import com.joshi.android_assignment_prashantadvait_foundation.R
import com.joshi.android_assignment_prashantadvait_foundation.model.data.ImageItem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen2(navController: NavController,imageItems: List<ImageItem>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "With ThirdParty loading image") },
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
                ImageGridCoil(imageItems)
            }
        }
    )
}

@Composable
fun ImageGridCoil(imageItems: List<ImageItem>) {
    LazyVerticalGrid(
        GridCells.Fixed(3),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(imageItems) { items ->
            ImageWithLabel(items.coverageURL, items.title)
        }
    }
}


@Composable
fun ImageWithLabel(imageUrl: String, labelText: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors()
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .error(R.drawable.icons_image_placeholder)
                    .crossfade(true)
                    .scale(Scale.FILL)
                    .build(),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = labelText,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}