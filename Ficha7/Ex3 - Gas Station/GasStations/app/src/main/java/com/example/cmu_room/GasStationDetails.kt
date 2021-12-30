package com.example.cmu_room

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.cmu_room.database.GasStationDB
import com.example.cmu_room.models.Fuel
import com.example.cmu_room.models.GasStation

private const val GAS_STATION = "GAS_STATION"

class GasStationDetails : Fragment() {
    private var gasStation: GasStation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            when (val obj = it.getSerializable(GAS_STATION)) {
                is GasStation -> gasStation = obj
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_gas_station_details, container, false)
        DisplayGasStationInfo(v, requireContext(), this.gasStation).start()


//        this.gasStation?.findFuel("Gasóleo simples")?.let{
//            v.findViewById<TextView>(R.id.diesel_simple_price).text = it.price.toString()
//            v.findViewById<TextView>(R.id.diesel_simple_price_updated).text = it.date.format(
//                DateTimeFormatter.ISO_DATE)
//        }
//        this.gasStation?.findFuel("Gasóleo especial")?.let{
//            v.findViewById<TextView>(R.id.diesel_special_price).text = it.price.toString()
//            v.findViewById<TextView>(R.id.diesel_special_price_updated).text = it.date.format(
//                DateTimeFormatter.ISO_DATE)
//        }
//        this.gasStation?.findFuel("Gasolina simples 95")?.let{
//            v.findViewById<TextView>(R.id.gasoline_95_simple_price).text = it.price.toString()
//            v.findViewById<TextView>(R.id.gasoline_95_simple_price_updated).text = it.date.format(
//                DateTimeFormatter.ISO_DATE)
//        }
//        this.gasStation?.findFuel("Gasolina especial 95")?.let{
//            v.findViewById<TextView>(R.id.gasoline_95_special_price).text = it.price.toString()
//            v.findViewById<TextView>(R.id.gasoline_95_special_price_updated).text = it.date.format(
//                DateTimeFormatter.ISO_DATE)
//        }
//        this.gasStation?.findFuel("Gasolina simples 98")?.let{
//            v.findViewById<TextView>(R.id.gasoline_98_simple_price).text = it.price.toString()
//            v.findViewById<TextView>(R.id.gasoline_98_simple_price_updated).text = it.date.format(
//                DateTimeFormatter.ISO_DATE)
//        }
//        this.gasStation?.findFuel("Gasolina especial 98")?.let{
//            v.findViewById<TextView>(R.id.gasoline_98_special_price).text = it.price.toString()
//            v.findViewById<TextView>(R.id.gasoline_98_special_price_updated).text = it.date.format(
//                DateTimeFormatter.ISO_DATE)
//        }
        return v
    }

    inner class DisplayGasStationInfo(val view: View, val context: Context, val gasStation: GasStation?) : Thread() {
        lateinit var fuels: List<Fuel>

        override fun run() {
            this.getFuels()
            this.displayFuelsInfo()

        }

        fun getFuels() {
            val db = GasStationDB.getInstance(context)
            db?.gasStationDao()?.let {
                fuels = it.getGasStationFuels(this.gasStation!!.id)
            }
        }

        fun displayFuelsInfo() {
            displayFuelInfo("Gasóleo simples", R.id.diesel_simple_price, R.id.diesel_simple_price_updated)
            displayFuelInfo("Gasóleo especial", R.id.diesel_special_price, R.id.diesel_special_price_updated)
            displayFuelInfo("Gasolina simples 95", R.id.gasoline_95_simple_price, R.id.gasoline_95_simple_price_updated)
            displayFuelInfo(
                "Gasolina especial 95",
                R.id.gasoline_95_special_price,
                R.id.gasoline_95_special_price_updated
            )
            displayFuelInfo(
                "Gasolina especial 98",
                R.id.gasoline_98_simple_price,
                R.id.gasoline_98_simple_price_updated
            )
        }

        fun displayFuelInfo(fuelName: String, priceViewId: Int, dateViewId: Int) {
            val fuel = this.fuels.find {
                it.fuelName == fuelName
            }
            val tvFuelPrice = this.view.findViewById<TextView>(priceViewId)
            val tvFuelDate = this.view.findViewById<TextView>(dateViewId)

            if (fuel != null) {
                tvFuelPrice.text = (fuel.price.toString() + " €")
                tvFuelDate.text = fuel.date.toString()
            } else {
                tvFuelPrice.text = "----"
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: GasStation) =
            GasStationDetails().apply {
                arguments = Bundle().apply {
                    putSerializable(GAS_STATION, param1)
                }
            }
    }
}