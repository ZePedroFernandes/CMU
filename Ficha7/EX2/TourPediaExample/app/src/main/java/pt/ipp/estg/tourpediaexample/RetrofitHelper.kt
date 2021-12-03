package pt.ipp.estg.tourpediaexample

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper {

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://tour-pedia.org/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    public fun getApi(): TourDataApi {
        return getRetrofit().create(TourDataApi::class.java)
    }

}