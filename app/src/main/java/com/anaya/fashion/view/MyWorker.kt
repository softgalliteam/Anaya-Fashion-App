package com.anaya.fashion.view

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.delay

class MyWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {
    var i = 0
    override suspend fun doWork(): Result {
        // Simulate a long-running task
        while (i <= 100) {
            delay(1 * 1000) // 1 Sec
            Log.d("MyWorkManager", "Download completed: $i %")
            i++
        }

        // Return success or failure based on the result of your task
        return Result.success()
    }
}
