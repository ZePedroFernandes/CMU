package com.example.cmu_room

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.example.cmu_room.classes.API_GasStationDetails
import com.example.cmu_room.classes.API_InfoPosto
import com.example.cmu_room.classes.API_Municipio_Response
import com.example.cmu_room.database.GasStationDB
import com.example.cmu_room.models.GasStation
import com.example.cmu_room.retrofit.GasStationAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MainActivity : AppCompatActivity(), GasStationFragment.GasStationListComunication,
    AddGasStationFragment.NoticeDialogListener {

    private var gasStationList: MutableList<GasStation> = ArrayList()
    private val listFragment = GasStationFragment.newInstance(gasStationList)
    private lateinit var apiInterface: GasStationAPI

    private val gasStationDao by lazy {
        GasStationDB.getInstance(context = applicationContext)?.gasStationDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.apiInterface = GasStationAPI.create()

        this.apiInterface.getListaPostosMunicipio(183)
            .enqueue(CallbackGasStationList())

        val fragmentTransaction = this.supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragmentContainerView, this.listFragment)
            .commit()

        updateList(this.gasStationList)
    }

    /**
     * Callback to handle the response of a gas station list.
     * For each Gas Station, the details are requested to the api and saved in the [gasStationList]
     */
    inner class CallbackGasStationList : Callback<API_Municipio_Response> {
        override fun onResponse(call: Call<API_Municipio_Response>, response: Response<API_Municipio_Response>) {
            Log.d("GASSTATIONAPI", "Sucesso ao fazer o pedido à API")
            val postos = response.body()?.resultado

            if (postos != null) {
                Log.d("GASSTATIONAPI", "Postos recebidos")
                this@MainActivity.gasStationList = ArrayList()

                requestGasStations(postos = postos)
            }
        }

        override fun onFailure(call: Call<API_Municipio_Response>, t: Throwable) {
            Log.d("GASSTATIONAPI", "Erro ao fazer o pedido à API")
        }

        fun requestGasStations(postos: List<API_InfoPosto>) {
            for (posto in postos) {
                Log.d("GASSTATIONAPI", "for")
                this@MainActivity.apiInterface.getInfoPosto(posto.Id)
                    .enqueue(CallbackGasStationDetails(posto.Id, postos.size))

            }
        }
    }

    inner class CallbackGasStationDetails(val id: Int, val numeroDePostos: Int) : Callback<API_GasStationDetails> {
        override fun onResponse(call: Call<API_GasStationDetails>, response: Response<API_GasStationDetails>) {
            val gasStationDetails = response.body()?.resultado

            if (gasStationDetails != null) {
                saveGasStationDetails(gasStationDetails)

                if (this.numeroDePostos == this@MainActivity.gasStationList.size) {
                    this@MainActivity.updateList(this@MainActivity.gasStationList)
                }
            }

        }

        override fun onFailure(call: Call<API_GasStationDetails>, t: Throwable) {
            Log.d("GASSTATIONAPI", "Erro ao fazer o pedido da Bomda de Combustivelà API")
        }

        fun saveGasStationDetails(detalhesPosto: API_GasStationDetails.Resultado) {
            val nome = detalhesPosto.Nome
            val morada = detalhesPosto.Morada.toString()
            val latitude = detalhesPosto.Morada.Latitude
            val longitude = detalhesPosto.Morada.Longitude

            val gasStation = GasStation(id, nome, morada, latitude, longitude)

            this@MainActivity.gasStationList.add(gasStation)
        }
    }

    override fun updateList(gasStatations: MutableList<GasStation>) {
        val dao = GasStationDB.getInstance(applicationContext)?.gasStationDao()
        val exec = GasStationDB.executors
        exec.execute {
            gasStationList.clear()
            gasStationList.addAll(dao?.getAll() as MutableList<GasStation>)
            this.listFragment.updateList()
        }

    }

    override fun goToDetails(position: Int) {
        val fragment = GasStationDetails.newInstance(this.gasStationList.get(position))
        val fragmentTransaction = this.supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
            .addToBackStack("GasStations")
            .commit()
    }

    override fun onDialogPositiveClick(gasStation: GasStation) {
        this.gasStationList.add(gasStation)
        Log.d("temp", this.gasStationList.size.toString() + " t1")

        val dao = GasStationDB.getInstance(this.applicationContext)?.gasStationDao()
        val exec = GasStationDB.executors

        exec.execute {
            dao?.insertGasStation(gasStation)
        }

        this.listFragment.updateList()
    }

    override fun onDialogNegativeClick(dialog: DialogFragment) {
        TODO("Not yet implemented")
    }

}