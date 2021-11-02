package pt.ipp.estg.spinnerlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class CountryDisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_display)

        findViewById<TextView>(R.id.tvCountry).text = intent.getStringExtra("country")
    }
}