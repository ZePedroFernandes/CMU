package com.example.cmu_room

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cmu_room.models.GasStation

private const val GAS_STATION = "GAS_STATION"

class GasStationDetails : Fragment() {
    private var gasStation: GasStation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            val obj = it.getSerializable(GAS_STATION)
            when (obj) {
                is GasStation -> gasStation = obj as GasStation
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_gas_station_details, container, false)
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