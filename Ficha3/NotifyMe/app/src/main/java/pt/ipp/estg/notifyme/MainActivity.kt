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
import android.content.BroadcastReceiver
import android.content.Context
import android.content.IntentFilter


class MainActivity : AppCompatActivity() {

    val CHANNEL_ID = "mychannel"
    val KEY_TEXT_REPLY = "key_text_reply"
    val notID = 1
    val replyIntent = Intent("replyIntent")
    val NOTIFICATION_DELETED = "Notification deleted"

    private val receiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            disableCancelBtn()
            disableUpdateBtn()
        }
    }

    private fun getNotiBuilder(text: String): NotificationCompat.Builder {

        val pending_intent =
            PendingIntent.getActivity(this, 0, replyIntent, PendingIntent.FLAG_IMMUTABLE)

        val remoteInput = RemoteInput.Builder(KEY_TEXT_REPLY).run {
            setLabel(getString(R.string.reply_label))
            build()
        }

        val replyAction = NotificationCompat.Action.Builder(0, "Reply", pending_intent)
            .addRemoteInput(remoteInput).build()

        val intent2 = Intent(this, MainActivity::class.java)
        val pendingIntent2 =
            PendingIntent.getActivity(this, 0, intent2, PendingIntent.FLAG_IMMUTABLE)
        val buttonAction =
            NotificationCompat.Action.Builder(R.drawable.notification_icon, "Title", pendingIntent2)
                .build()

        val deleteIntent = Intent(NOTIFICATION_DELETED)
        val deletePendingIntent = PendingIntent.getBroadcast(this, 1, deleteIntent, 0)
        registerReceiver(receiver, IntentFilter(NOTIFICATION_DELETED))

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
            .addAction(buttonAction)
            .setDeleteIntent(deletePendingIntent)


        return mBuilder
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("ActivityControl", "create")

        createNotificationChannel()
        setButtonsListeners()

    }

    fun enableUpdateBtn() {
        val btnUpdate = findViewById<Button>(R.id.btnUpdateNotification)

        btnUpdate.isEnabled = true
        btnUpdate.background = getDrawable(R.color.purple_500)
    }

    fun enableCancelBtn() {
        val btnCancel = findViewById<Button>(R.id.btnCancelNotification)

        btnCancel.isEnabled = true
        btnCancel.background = getDrawable(R.color.purple_500)
    }

    fun disableCancelBtn() {
        val btnCancel = findViewById<Button>(R.id.btnCancelNotification)

        btnCancel.isEnabled = false
        btnCancel.background = getDrawable(R.color.cardview_shadow_start_color)

    }

    fun disableUpdateBtn() {
        val btnUpdateNot = findViewById<Button>(R.id.btnUpdateNotification)

        btnUpdateNot.isEnabled = false
        btnUpdateNot.background = getDrawable(R.color.cardview_shadow_start_color)
    }

    fun setButtonsListeners() {
        val btnSend = findViewById<Button>(R.id.btnNotification)
        val btnCancel = findViewById<Button>(R.id.btnCancelNotification)
        val btnUpdateNot = findViewById<Button>(R.id.btnUpdateNotification)

        val notifyMgr = NotificationManagerCompat.from(this)
        val mBuilder = getNotiBuilder("Olha a notificação")

        btnSend.setOnClickListener {
            notifyMgr.notify(notID, mBuilder.build())
            enableCancelBtn()
            enableUpdateBtn()
        }

        btnCancel.setOnClickListener {
            notifyMgr.cancel(notID)
            disableCancelBtn()
            disableUpdateBtn()
        }

        btnUpdateNot.setOnClickListener {
            val updateText = findViewById<EditText>(R.id.updateText)
            mBuilder.setContentText(updateText.text.toString())

            notifyMgr.notify(notID, mBuilder.build())
        }
    }

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

    override fun onStart() {
        super.onStart()
        Log.i("ActivityControl", "start")
    }

    override fun onResume() {
        super.onResume()
        Log.i("ActivityControl", "resume")

    }

    override fun onPause() {
        super.onPause()
        Log.i("ActivityControl", "pause")
    }

    override fun onStop() {
        super.onStop()

        Log.i("ActivityControl", "stop")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("ActivityControl", "destroy")
    }

    override fun onRestart() {
        super.onRestart()

        Log.i("ActivityControl", "restart")
    }

}