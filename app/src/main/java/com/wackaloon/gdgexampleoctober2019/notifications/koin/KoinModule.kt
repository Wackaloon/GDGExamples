package com.wackaloon.gdgexampleoctober2019.notifications.koin

import com.wackaloon.gdgexampleoctober2019.notifications.NotificationHelper
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val NotificationsModule = module {
    factory { NotificationHelper(context = androidContext()) }
}
