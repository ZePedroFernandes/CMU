package fichas.fragments.fragments

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import fichas.fragments.R
import fichas.fragments.models.City

class CityDetailsFragment(): Fragment(R.layout.city_details) {
    private lateinit var city: City

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let{
            city = it.getSerializable("city") as City
        }

        view.findViewById<TextView>(R.id.tvCityName).text = city.name
        view.findViewById<TextView>(R.id.tvCountryName).text = city.country
        view.findViewById<TextView>(R.id.tvCityDescription).text = city.description

    }
}