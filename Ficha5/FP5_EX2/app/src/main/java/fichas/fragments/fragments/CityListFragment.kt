package fichas.fragments.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fichas.fragments.Communication
import fichas.fragments.MainActivity
import fichas.fragments.R
import fichas.fragments.adapters.CityAdapter
import fichas.fragments.models.City

class CityListFragment() : Fragment(R.layout.city_list) {
    private lateinit var communication: Communication
    private lateinit var dataset: MainActivity.cityList<City>

    override fun onAttach(context: Context) {
        super.onAttach(context)

        this.communication = context as Communication
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let{
            this.dataset = it.getSerializable("cityList") as MainActivity.cityList<City>
        }

        val cityAdapter = CityAdapter(communication, dataset)

        view.findViewById<RecyclerView>(R.id.rvCities).apply {
            adapter = cityAdapter
            layoutManager = LinearLayoutManager(this@CityListFragment.requireContext())
        }
    }

}