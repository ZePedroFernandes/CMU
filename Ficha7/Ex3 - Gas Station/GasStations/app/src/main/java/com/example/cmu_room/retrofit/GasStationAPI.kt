package com.example.cmu_room.retrofit

import com.example.cmu_room.classes.API_GasStationDetails
import com.example.cmu_room.classes.API_Municipio_Response
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface GasStationAPI {

    @GET("ListarDadosPostos")
    fun getListaPostosMunicipio(@Query("idsMunicipios") idMunicipio: Int): Call<API_Municipio_Response>

    @GET("GetDadosPosto")
    fun getInfoPosto(@Query("id") idPosto: Int): Call<API_GasStationDetails>

    companion object {

        var BASE_URL = "https://precoscombustiveis.dgeg.gov.pt/api/PrecoComb/"

        fun create(): GasStationAPI {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(GasStationAPI::class.java)
        }
    }

}
