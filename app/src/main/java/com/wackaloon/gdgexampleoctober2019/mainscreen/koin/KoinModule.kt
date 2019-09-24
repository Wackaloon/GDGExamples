package com.wackaloon.gdgexampleoctober2019.mainscreen.koin

import com.wackaloon.gdgexampleoctober2019.mainscreen.data.datasource.DataSource
import com.wackaloon.gdgexampleoctober2019.mainscreen.data.datasource.DataSourceOfSomething
import com.wackaloon.gdgexampleoctober2019.mainscreen.data.navigation.Navigator
import com.wackaloon.gdgexampleoctober2019.mainscreen.data.repository.RepositoryImpl
import com.wackaloon.gdgexampleoctober2019.mainscreen.data.mvp.Presenter
import com.wackaloon.gdgexampleoctober2019.mainscreen.data.mvp.PresenterImpl
import com.wackaloon.gdgexampleoctober2019.mainscreen.domain.repository.Repository
import com.wackaloon.gdgexampleoctober2019.mainscreen.domain.usecase.UseCase
import com.wackaloon.gdgexampleoctober2019.mainscreen.framework.datasource.DataSourceImpl
import com.wackaloon.gdgexampleoctober2019.mainscreen.framework.datasource.DataSourceOfSomethingImpl
import com.wackaloon.gdgexampleoctober2019.mainscreen.framework.navigation.NavigatorImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val MainScreenModule = module {
    factory { DataSourceImpl(context = androidContext()) as DataSource }
    factory { DataSourceOfSomethingImpl(
        context = androidContext()
    ) as DataSourceOfSomething }
    factory { RepositoryImpl(
        dataSource = get(),
        dataSourceOfSomething = get()
    ) as Repository
    }
    factory { UseCase(repository = get()) }
    factory { PresenterImpl(
        useCase = get(),
        navigator = get()
    ) as Presenter
    }
    factory { NavigatorImpl(
        context = androidContext(),
        notificationHelper = get()
    ) as Navigator }
}
