package com.wackaloon.gdgexampleoctober2019.mainscreen.framework.datasource

import android.content.Context
import androidx.work.ArrayCreatingInputMerger
import androidx.work.Data
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.wackaloon.gdgexampleoctober2019.mainscreen.data.datasource.DataSource
import com.wackaloon.gdgexampleoctober2019.mainscreen.framework.workers.CoroutineCompressWorker
import com.wackaloon.gdgexampleoctober2019.mainscreen.framework.workers.CoroutinesFilterWorker
import com.wackaloon.gdgexampleoctober2019.mainscreen.framework.workers.CoroutinesUploadWorker

class DataSourceImpl(private val context: Context) : DataSource {

    override fun uploadSomething(something: List<String>) {

        val listOfFilters = something.map {
            OneTimeWorkRequest.Builder(CoroutinesFilterWorker::class.java)
                .setInputData(Data.Builder().putString("data", it).build())
                .build()
        }

        val compress = OneTimeWorkRequest.Builder(CoroutineCompressWorker::class.java)
            // this will allow compress to get all data from filters as an array
            .setInputMerger(ArrayCreatingInputMerger::class.java)
            .build()

        val upload = OneTimeWorkRequest.Builder(CoroutinesUploadWorker::class.java).build()

        WorkManager.getInstance(context)
            .beginWith(listOfFilters)
            .then(compress)
            .then(upload)
            .enqueue()
    }
}
