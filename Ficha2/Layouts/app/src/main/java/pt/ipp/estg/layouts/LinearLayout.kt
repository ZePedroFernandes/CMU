package pt.ipp.estg.layouts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class LinearLayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.linear_layout)

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener{
            val intent= Intent(this, RelativeLayout::class.java)
            startActivity(intent)
        }

    }
}