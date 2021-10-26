package pt.ipp.estg.layouts

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TableLayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.table_layout)

        val button = findViewById<Button>(R.id.button2)

        button.setOnClickListener{
            finish()
        }
    }
}