package com.wackaloon.gdgexampleoctober2019.mainscreen.framework.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.Data
import androidx.work.WorkerParameters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext

class CoroutineCompressWorker(
    context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result = coroutineScope {
        withContext(Dispatchers.IO) {
            Log.d("CoroutineCompressWorker", inputData.toString())
            val input = inputData.getStringArray("filterData")
            val data = compressData(input)
            Result.success(Data.Builder().putString("data", data).build())
        }
    }

    private fun compressData(input: Array<String>?): String {
        return input?.fold("", { start, plus -> start + plus }) ?: "error"
    }
}


