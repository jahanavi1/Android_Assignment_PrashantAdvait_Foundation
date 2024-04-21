package com.joshi.android_assignment_prashantadvait_foundation.Utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import java.io.File
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

object CacheDiskRelated {

    fun downloadBitmapFromUrl(url: String): Bitmap? {
        return try {
            val connection = (URL(url).openConnection() as HttpURLConnection).apply {
                connectTimeout = 10_000
                readTimeout = 10_000
                connect()
            }
            val inputStream: InputStream = connection.inputStream
            BitmapFactory.decodeStream(inputStream)
        } catch (e: Exception) {
            Log.e("ImageLoader", "Error downloading image: ${e.message}")
            null
        }
    }

    fun cacheBitmapToDisk(context: Context, bitmap: Bitmap, cacheKey: String): File? {
        return try {
            val cacheFile = File(context.cacheDir, cacheKey)
            cacheFile.outputStream().use { output ->
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, output)
            }
            cacheFile
        } catch (e: Exception) {
            Log.e("ImageLoader", "Error caching image: ${e.message}")
            null
        }
    }


    fun loadCachedBitmapFromDisk(context: Context, cacheKey: String): Bitmap? {
        val cacheFile = File(context.cacheDir, cacheKey)
        return if (cacheFile.exists()) {
            BitmapFactory.decodeFile(cacheFile.absolutePath)
        } else {
            null
        }
    }
}