package com.joshi.android_assignment_prashantadvait_foundation.view.withoutCoil

import android.content.Context
import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joshi.android_assignment_prashantadvait_foundation.R
import com.joshi.android_assignment_prashantadvait_foundation.Utils.CacheDiskRelated
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ImageGridItem(imageUrl: String, context: Context, title: String) {
    val scope = rememberCoroutineScope()
    var bitmap by remember { mutableStateOf<Bitmap?>(null) }
    var loadingError by remember { mutableStateOf(false) }

    LaunchedEffect(imageUrl) {
        val cacheKey = imageUrl.hashCode().toString()

        bitmap = CacheDiskRelated.loadCachedBitmapFromDisk(context, cacheKey)

        if (bitmap == null) {
            scope.launch(Dispatchers.IO) {
                val downloadedBitmap = CacheDiskRelated.downloadBitmapFromUrl(imageUrl)
                if (downloadedBitmap != null) {
                    CacheDiskRelated.cacheBitmapToDisk(context, downloadedBitmap, cacheKey)
                    bitmap = downloadedBitmap
                } else {
                    loadingError = true
                }
            }
        }
    }
    ImageWithTitleCard(bitmap, title, Modifier)
}


@Composable
fun ImageWithTitleCard(bitmap: Bitmap?, title: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
        ) {


            if (bitmap != null) {
                Image(
                    bitmap = bitmap.asImageBitmap(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                )
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icons_image_placeholder),
                        contentDescription = "Placeholder image",
                        modifier = Modifier.aspectRatio(1f),
                        contentScale = ContentScale.Crop
                    )
                }

            }
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = title.trim(),
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


