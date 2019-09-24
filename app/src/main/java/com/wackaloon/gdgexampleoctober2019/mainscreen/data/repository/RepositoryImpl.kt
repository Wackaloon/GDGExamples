package com.wackaloon.gdgexampleoctober2019.mainscreen.data.repository

import com.wackaloon.gdgexampleoctober2019.mainscreen.data.datasource.DataSource
import com.wackaloon.gdgexampleoctober2019.mainscreen.data.datasource.DataSourceOfSomething
import com.wackaloon.gdgexampleoctober2019.mainscreen.domain.repository.Repository

class RepositoryImpl(
    private val dataSource: DataSource,
    private val dataSourceOfSomething: DataSourceOfSomething
) : Repository {

    override fun uploadSomething() {
        val something = dataSourceOfSomething.getSomething()
        return dataSource.uploadSomething(something)
    }
}
