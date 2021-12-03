package pt.ipp.estg.tourpediaexample

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TourDataApi {
    @GET("getPlaces")
    fun getListPointOfInteres(
        @Query("location") location: String,
        @Query("category") category: String,
        @Query("name") name: String
    ): Call<List<Place>>
}