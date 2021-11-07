package fichas.fragments.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fichas.fragments.Communication
import fichas.fragments.R
import fichas.fragments.adapters.CityAdapter
import fichas.fragments.models.City


class CityListFragment(private val communication: Communication, private val dataset: List<City>) : Fragment(R.layout.city_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cityAdapter = CityAdapter(communication, dataset)

        view.findViewById<RecyclerView>(R.id.rvCities).apply {
            adapter = cityAdapter
            layoutManager = LinearLayoutManager(this@CityListFragment.requireContext())
        }
    }

}