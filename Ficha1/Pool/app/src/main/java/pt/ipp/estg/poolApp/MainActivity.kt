package pt.ipp.estg.poolApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet


class MainActivity : AppCompatActivity() {

    fun createNewChart() {
        val chart = findViewById<LineChart>(R.id.chart)
        var entries = ArrayList<Entry>()
        for (i in 0..10) {
            entries.add(Entry(i.toFloat(), Math.random().toFloat()))
        }

        val dataSet = LineDataSet(entries, "label")
        val lineData = LineData(dataSet)

        chart.data = lineData
        chart.invalidate()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createNewChart()
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            createNewChart()
        }
    }
}