package fichas.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import fichas.fragments.fragments.CityDetailsFragment
import fichas.fragments.fragments.CityListFragment
import fichas.fragments.models.City

class MainActivity : AppCompatActivity(), Communication {

    private val cities = listOf<City>(
        City("Portugal", "Porto", "Descrição"),
        City("Portugal", "Aveiro", "Descrição"),
        City("Portugal", "Lisboa", "Descrição"),
        City("Portugal", "Algarve", "Descrição"),
        City("Portugal", "Vila Real", "Descrição"),
        City("Portugal", "Braga", "Descrição"),
        City("Portugal", "Viana Do Castelo", "Descrição")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentList = CityListFragment(this, cities)

        if (findViewById<ConstraintLayout>(R.id.clLargeLayout) == null){
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
        val fragment = CityDetailsFragment(city)

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