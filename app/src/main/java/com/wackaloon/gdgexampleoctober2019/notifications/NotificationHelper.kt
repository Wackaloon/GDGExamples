package com.wackaloon.gdgexampleoctober2019.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat.*
import androidx.core.app.NotificationManagerCompat
import com.wackaloon.gdgexampleoctober2019.R


private val CHANNEL_ID = "0"
private val FULLSCREEN_INTENT_ID = 0

class NotificationHelper(private val context: Context) {

    init {
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "0"
            val descriptionText = "description"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    fun showFullScreenPendingIntentNotification(intent: Intent) {
        val fullScreenPendingIntent = PendingIntent.getActivity(
            context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT
        )

        val notificationBuilder = Builder(context, CHANNEL_ID)
            .setPriority(PRIORITY_MAX) // required
            .setContentText("Open second screen") // not required, just for convenience
            .setSmallIcon(R.mipmap.ic_launcher)
            .setAutoCancel(true) // not required, just for convenience
            .setDefaults(DEFAULT_SOUND or DEFAULT_VIBRATE) // required
            .setFullScreenIntent(fullScreenPendingIntent, true) // required

        // WARNING!!!
        // if heads up or full screen is not shown - check notification settings for the app
        // you may have to enable "Banner" or "Heads  up" notifications manually
        with(NotificationManagerCompat.from(context)) {
            notify(FULLSCREEN_INTENT_ID, notificationBuilder.build())
        }
    }
}
