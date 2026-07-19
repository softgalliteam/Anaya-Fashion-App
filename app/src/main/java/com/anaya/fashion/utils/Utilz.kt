package com.anaya.fashion.utils

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.core.content.FileProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.net.HttpURLConnection
import java.net.URL

object Utilz {
    fun shareProductDetails(context: Context, imageUrl: String, shareText: String) {
        // Perform network operations off the main thread
        CoroutineScope(Dispatchers.IO).launch {
            val bitmap = downloadBitmap(imageUrl)
            if (bitmap != null) {
                val contentUri = saveBitmapToCache(context, bitmap)
                if (contentUri != null) {
                    triggerShareIntent(context, contentUri, shareText)
                }
            }
        }
    }

    // 1. Download image from URL to Bitmap
    private suspend fun downloadBitmap(imageUrl: String): Bitmap? = withContext(Dispatchers.IO) {
        try {
            val url = URL(imageUrl)
            val connection = url.openConnection() as HttpURLConnection
            connection.doInput = true
            connection.connect()
            BitmapFactory.decodeStream(connection.inputStream)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    // 2. Save Bitmap into internal cache and retrieve FileProvider Uri
    private suspend fun saveBitmapToCache(context: Context, bitmap: Bitmap): Uri? =
        withContext(Dispatchers.IO) {
            try {
                val cachePath = File(context.cacheDir, "images")
                cachePath.mkdirs() // Ensure directory exists

                val file = File(cachePath, "shared_image.png")
                val stream = FileOutputStream(file)
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
                stream.close()

                // Get URI using the authority defined in your Manifest
                FileProvider.getUriForFile(context, "${context.packageName}.fileprovider", file)
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }

    // 3. Launch the Android Share Sheet with granted read permissions
    private fun triggerShareIntent(context: Context, contentUri: Uri, shareText: String) {
        val playStoreLink = "https://play.google.com/store/apps/details?id=com.anaya.fashion&hl=en_IN"
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "image/*"
            putExtra(Intent.EXTRA_TEXT, "$shareText\n$playStoreLink")             // Add your description text
            putExtra(Intent.EXTRA_STREAM, contentUri)          // Add your local file URI
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)    // Vital for Android 6.0+ permissions
        }

        val chooser = Intent.createChooser(shareIntent, "Share post via...")
        context.startActivity(chooser)
    }
}