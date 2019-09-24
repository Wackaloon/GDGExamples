package com.wackaloon.gdgexampleoctober2019.mainscreen.framework.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.Data
import androidx.work.WorkerParameters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import kotlin.random.Random

class CoroutinesFilterWorker(
    context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result = coroutineScope {
        withContext(Dispatchers.IO) {
            val data = inputData.getString("data")
            val filteredData = data + "_" + Random.nextInt().toString()
            Result.success(
                Data.Builder()
                    .putString("filterData", filteredData)
                    .build()
            )
        }
    }
}
