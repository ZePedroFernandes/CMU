package fichas.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.os.bundleOf
import fichas.fragments.fragments.CityDetailsFragment
import fichas.fragments.fragments.CityListFragment
import fichas.fragments.models.City
import java.io.Serializable

class MainActivity : AppCompatActivity(), Communication {

    private var cities: cityList<City> = cityList()

    inner class cityList<T>() : ArrayList<T>(), Serializable {
    }

    fun createCityList() {
        cities.apply {
            add(City("Portugal", "Porto", "Descrição"))
            add(City("Portugal", "Aveiro", "Descrição"))
            add(City("Portugal", "Lisboa", "Descrição"))
            add(City("Portugal", "Algarve", "Descrição"))
            add(City("Portugal", "Vila Real", "Descrição"))
            add(City("Portugal", "Braga", "Descrição"))
            add(City("Portugal", "Viana Do Castelo", "Descrição"))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createCityList()
        val fragmentCityListBundle = Bundle()
        fragmentCityListBundle.putSerializable("cityList", cities)

        val fragmentList = CityListFragment().apply {
            arguments = fragmentCityListBundle
        }

        if (findViewById<ConstraintLayout>(R.id.clLargeLayout) == null) {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flContainer, fragmentList)
                commit()
            }
        } else {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flList, fragmentList)
                commit()
            }
        }

    }

    override fun selectCity(city: City) {
        val fragment = CityDetailsFragment()
        fragment.apply {
            val bundle = Bundle()
            bundle.putSerializable("city", city)
            arguments = bundle
        }


        val isSmallDisplay = findViewById<ConstraintLayout>(R.id.clLargeLayout) == null
        if (isSmallDisplay) {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flContainer, fragment)
                addToBackStack("CityDescription")
                commit()
            }
        } else {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flDescription, fragment)
                commit()
            }
        }

    }


}

interface Communication {
    fun selectCity(city: City)
}