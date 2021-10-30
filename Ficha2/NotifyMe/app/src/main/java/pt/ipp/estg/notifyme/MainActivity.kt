package pt.ipp.estg.notifyme

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {

    val CHANNEL_ID = "mychannel"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createNotificationChannel()

        val intent = Intent("asdfg")
        val pending_intent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        val mBuilder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.notification_ancor)
            .setContentTitle("Foi notificado")
            .setContentText("Notificação")
            .setAutoCancel(true)
            .setContentIntent(pending_intent)

        val btnNotification = findViewById<Button>(R.id.btnNotification)
        val btnCancelNotification = findViewById<Button>(R.id.btnCancelNotification)
        val mNotifyMgr = NotificationManagerCompat.from(this)

        Log.i("color", btnCancelNotification.textColors.toString())

        btnNotification.setOnClickListener {
            mNotifyMgr.notify(1, mBuilder.build())
            btnCancelNotification.isEnabled = true
            btnCancelNotification.background = getDrawable(R.color.purple_500)
            btnCancelNotification.setTextColor(getColor(R.color.white))
        }


        btnCancelNotification.setOnClickListener {
            mNotifyMgr.cancel(1)
            btnCancelNotification.isEnabled = false
            btnCancelNotification.background = getDrawable(R.color.cardview_shadow_start_color)
        }

    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val description = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT;

            val channel = NotificationChannel(CHANNEL_ID, name, importance)

            channel.description = description

            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }
}