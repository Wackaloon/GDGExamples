package com.wackaloon.gdgexampleoctober2019.mainscreen.framework.datasource

import android.content.Context
import com.wackaloon.gdgexampleoctober2019.mainscreen.data.datasource.DataSourceOfSomething

class DataSourceOfSomethingImpl(private val context: Context) : DataSourceOfSomething {

    override fun getSomething(): List<String> {
        return listOf("wololo", "hank", "arshvirdrobvil")
    }
}
