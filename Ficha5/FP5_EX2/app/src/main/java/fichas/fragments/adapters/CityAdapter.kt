package fichas.fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fichas.fragments.Communication
import fichas.fragments.R
import fichas.fragments.models.City

class CityAdapter(private val communication: Communication, private val dataset: List<City>) :
    RecyclerView.Adapter<CityAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val btnCityName: Button = view.findViewById(R.id.btnCity)
        val countryName: TextView = view.findViewById(R.id.tvCountry)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.city_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val city = dataset[position]

        holder.apply {
            countryName.text = city.country
            btnCityName.text = city.name
            btnCityName.setOnClickListener{
                communication.selectCity(city)
            }
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}