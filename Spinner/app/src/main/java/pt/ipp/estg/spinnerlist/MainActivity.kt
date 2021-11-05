package pt.ipp.estg.spinnerlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnAccept).setOnClickListener {
            val spCountries = findViewById<Spinner>(R.id.spCountries)
            val intent = Intent(this, CountryDisplayActivity::class.java).apply {
                putExtra("country", spCountries.selectedItem.toString())
            }

            startActivity(intent)

        }
    }
}