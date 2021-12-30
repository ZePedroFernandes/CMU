package com.example.cmu_room

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cmu_room.models.GasStation
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.io.Serializable

private const val GAS_STATION_LIST = "gas_station_list"

class GasStationFragment : Fragment() {

    private var columnCount = 1
    private lateinit var gasStationList: MutableList<GasStation>
    private lateinit var mainInterface: GasStationListComunication

    override fun onAttach(context: Context) {
        super.onAttach(context)
        when (context) {
            is GasStationListComunication -> this.mainInterface =
                context
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            gasStationList = it.getSerializable(GAS_STATION_LIST) as MutableList<GasStation>
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_gas_station_list, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.list)

        if (recyclerView is RecyclerView) {
            with(recyclerView) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                gasStationList.let {
                    adapter = GasStationRecyclerViewAdapter(it, mainInterface)
                }
            }
        }

        val fb = view.findViewById<FloatingActionButton>(R.id.floating_button)
        fb.setOnClickListener {

            val dialog = AddGasStationFragment()
            dialog.show(childFragmentManager, "NoticeDialogFragment")

        }
        return view
    }

    fun updateList() {
        Log.d("temp", this.gasStationList.size.toString() + " t2")
        view?.let {
            it.findViewById<RecyclerView>(R.id.list)?.let {

                it.adapter?.let {
                    Log.d("temp", it.itemCount.toString() + " t2")
                    it.notifyDataSetChanged()
                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(list: MutableList<GasStation>) =
            GasStationFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(GAS_STATION_LIST, list as Serializable)
                }
            }
    }

    interface GasStationListComunication {
        fun updateList(gasStatations: MutableList<GasStation>)
        fun goToDetails(position: Int)
    }

}