package com.wackaloon.gdgexampleoctober2019

import android.app.Application
import com.wackaloon.gdgexampleoctober2019.mainscreen.koin.MainScreenModule
import com.wackaloon.gdgexampleoctober2019.notifications.koin.NotificationsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(
                listOf(
                    MainScreenModule,
                    NotificationsModule
                )
            )
        }
    }
}
