package pt.ipp.estg.tourpediaexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RetrofitHelper().getApi().getListPointOfInteres("Amsterdam", "attraction", "Science")
            .enqueue(object : Callback<List<Place>> {
                override fun onResponse(call: Call<List<Place>>, response: Response<List<Place>>) {
                    val points: List<Place> = response.body() as List<Place>
                    findViewById<RecyclerView>(R.id.rvPlacesList).apply {
                        adapter = PlacesAdapter(points)
                        layoutManager = LinearLayoutManager(this@MainActivity)
                    }

                }

                override fun onFailure(call: Call<List<Place>>, t: Throwable) {
                    Log.d("QQ", t.message.toString())
                }
            })
    }
}