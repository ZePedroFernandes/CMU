package pt.ipp.estg.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chat_layout)

        findViewById<TextView>(R.id.tvContactName).text = intent.getStringExtra("contactName").toString()

        findViewById<Button>(R.id.btnBack).setOnClickListener {
            finish()
        }
    }
}