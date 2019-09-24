package com.wackaloon.gdgexampleoctober2019.mainscreen.framework.navigation

import android.content.Context
import com.wackaloon.gdgexampleoctober2019.mainscreen.data.navigation.Navigator
import com.wackaloon.gdgexampleoctober2019.notifications.NotificationHelper
import com.wackaloon.gdgexampleoctober2019.secondscreen.framework.SecondScreenActivity

class NavigatorImpl(
    private val context: Context,
    private val notificationHelper: NotificationHelper
) : Navigator {

    override fun openSecondScreenAtAnyCost() {
        val fullScreenIntent = SecondScreenActivity.getIntent(context)
        notificationHelper.showFullScreenPendingIntentNotification(fullScreenIntent)
    }
}
