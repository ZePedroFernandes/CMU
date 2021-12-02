package com.example.cmu_room

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.example.cmu_room.database.GasStationDB
import com.example.cmu_room.models.GasStation
import com.example.cmu_room.placeholder.PlaceholderContent

class MainActivity : AppCompatActivity(), GasStationFragment.GasStationListComunication,
    AddGasStationFragment.NoticeDialogListener {

    private var gasStationList: MutableList<GasStation> = PlaceholderContent.ITEMS
    private val listFragment = GasStationFragment.newInstance(gasStationList)

    private val gasStationDao by lazy {
        GasStationDB.getInstance(context = applicationContext)?.gasStationDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fmt = supportFragmentManager.beginTransaction()
        fmt.add(R.id.fragmentContainerView, listFragment)
            .commit()

        updateList(gasStationList)

    }

    override fun updateList(gasStatations: MutableList<GasStation>) {
        val dao = GasStationDB.getInstance(context = applicationContext)?.gasStationDao()
        val exec = GasStationDB.executors
        exec.execute {
            gasStationList.clear()
            gasStationList.addAll(dao?.getAll() as MutableList<GasStation>)
            listFragment.updateList()
        }

    }

    override fun goToDetails(position: Int) {
        val fragment = GasStationDetails.newInstance(this.gasStationList.get(position))
        val fmt = supportFragmentManager.beginTransaction()
        fmt.replace(R.id.fragmentContainerView, fragment)
            .addToBackStack("GasStations")
            .commit()
    }

    override fun onDialogPositiveClick(gasStation: GasStation) {
        this.gasStationList.add(gasStation)
        Log.d("temp", this.gasStationList.size.toString() + " t1")

        val dao = GasStationDB.getInstance(context = applicationContext)?.gasStationDao()
        val exec = GasStationDB.executors

        exec.execute {
            dao?.insertGasStation(gasStation)
        }

        listFragment.updateList()
    }

    override fun onDialogNegativeClick(dialog: DialogFragment) {
        TODO("Not yet implemented")
    }

}