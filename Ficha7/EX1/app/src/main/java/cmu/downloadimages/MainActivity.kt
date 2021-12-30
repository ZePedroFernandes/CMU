package cmu.downloadimages

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import cmu.downloadimages.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity() {

    private val imageName = "imagemEx1Ficha7.png"
    private var downloadID: Long? = null
    private val onDownloadReceived = object : BroadcastReceiver() {

        override fun onReceive(context: Context?, intent: Intent?) {
            val id: Long = intent!!.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1)
            if (id == downloadID) {
                val file = getExternalFilesDir(null)
                val path = file?.absolutePath + "/" + imageName

                findViewById<ImageView>(R.id.ivDownloaded).setImageURI(path.toUri())
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        registerReceiver(onDownloadReceived, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))

        binding.btnAsyncActivity.setOnClickListener {
            beginDownload()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(onDownloadReceived)
    }

    private fun beginDownload() {

        val file = File(getExternalFilesDir(null), imageName);

        if (file.exists()) {
            file.delete()
        }

        val request = DownloadManager.Request(Uri.parse("https://www.ipp.pt./logo-ipp.png"))
            .setTitle(imageName)
            .setDescription("Downloading")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
            .setDestinationUri(Uri.fromFile(file))
            .setAllowedOverMetered(true)
            .setAllowedOverRoaming(true)


        val downloadManager = getSystemService(DOWNLOAD_SERVICE) as DownloadManager
        downloadID = downloadManager.enqueue(request)

    }
}
