package pt.ipp.estg.hugearraylist

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val images: ArrayList<DummyObject> = ArrayList(500)

        for (i in 0..500)
            images.add(DummyObject(R.drawable.tree_image, i))

        val adapter = DummyAdapter(this, R.layout.dummy_layout, images.toList())

        findViewById<ListView>(R.id.lvMyListView).adapter = adapter
    }
}