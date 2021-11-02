package pt.ipp.estg.notifyme

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.RemoteInput

class MainActivity : AppCompatActivity() {

    val CHANNEL_ID = "mychannel"
    val KEY_TEXT_REPLY = "key_text_reply"
    val notID = 1

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager = getSystemService(NotificationManager::class.java)
            val channelName = getString(R.string.channel_name)

            val channel = NotificationChannel(
                CHANNEL_ID,
                channelName,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                this.description = getString(R.string.channel_description)
            }

            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun getNotiBuilder(text: String): NotificationCompat.Builder {

        val intent = Intent("asdfg")
        val pending_intent =
            PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        val remoteInput = RemoteInput.Builder(KEY_TEXT_REPLY).run {
            setLabel(getString(R.string.reply_label))
            build()
        }

        val replyAction = NotificationCompat.Action.Builder(0, "Reply", pending_intent)
            .addRemoteInput(remoteInput).build()


        val mBuilder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.notification_ancor)
            .setContentTitle("Foi notificado")
            .setContentText(text)
            .setAutoCancel(true)
            .setContentIntent(pending_intent)
            .setStyle(
                NotificationCompat.BigPictureStyle()
                    .bigPicture(BitmapFactory.decodeResource(resources, R.drawable.treeimage))
            )
            .addAction(replyAction)

        return mBuilder
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createNotificationChannel()
        val mBuilder = getNotiBuilder("Olha a notificação")

        val btnSendNot = findViewById<Button>(R.id.btnNotification)
        val btnCancelNot = findViewById<Button>(R.id.btnCancelNotification)
        val btnUpdateNot = findViewById<Button>(R.id.btnUpdateNotification)

        val notifyMgr = NotificationManagerCompat.from(this)

        btnSendNot.setOnClickListener {
            notifyMgr.notify(notID, mBuilder.build())
            btnCancelNot.isEnabled = true
            btnUpdateNot.isEnabled = true

            btnCancelNot.background = getDrawable(R.color.purple_500)
            btnUpdateNot.background = getDrawable(R.color.purple_500)

            btnCancelNot.setTextColor(getColor(R.color.white))
            btnUpdateNot.setTextColor(getColor(R.color.white))
        }

        btnCancelNot.setOnClickListener {
            notifyMgr.cancel(notID)
            btnCancelNot.isEnabled = false
            btnUpdateNot.isEnabled = false

            btnCancelNot.background = getDrawable(R.color.cardview_shadow_start_color)
            btnUpdateNot.background = getDrawable(R.color.cardview_shadow_start_color)
        }

        btnUpdateNot.setOnClickListener {
            val updateText = findViewById<EditText>(R.id.updateText)
            mBuilder.setContentText(updateText.text.toString())


            notifyMgr.notify(notID, mBuilder.build())
        }

    }


}