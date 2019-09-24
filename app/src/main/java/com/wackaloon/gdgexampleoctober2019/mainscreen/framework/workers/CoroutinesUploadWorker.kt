package com.wackaloon.gdgexampleoctober2019.mainscreen.framework.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext

class CoroutinesUploadWorker(
    context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result = coroutineScope {
        withContext(Dispatchers.IO) {
            val input = inputData.getString("compressData")
            upload(input)
            Result.success()
        }
    }

    private fun upload(data: String?) {
        Log.d("CoroutinesUploadWorker", data)
        // some magic happens here
    }
}


