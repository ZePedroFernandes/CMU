package pt.ipp.estg.layouts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RelativeLayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.relative_layout)

        val button = findViewById<Button>(R.id.button4)

        button.setOnClickListener{
            startActivity(Intent(this, TableLayout::class.java))
        }
    }
}