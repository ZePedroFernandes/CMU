package com.example.cmu_room.database

import androidx.room.*
import com.example.cmu_room.models.Fuel
import com.example.cmu_room.models.GasStation
import com.example.cmu_room.models.GasStationAndFuels

@Dao
interface GasStationDao {

    @Query("SELECT * FROM gasstation")
    fun getAll(): List<GasStation>

    @Query("SELECT * FROM gasstation WHERE gasstation.id = :id")
    fun getGasStation(id: Int): GasStation

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGasStation(gasStation: GasStation): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFuel(fuel: Fuel)

    @Query("SELECT * FROM Fuel WHERE id = :id")
    fun getFuel(id: Int): List<Fuel>

    @Query("SELECT * FROM Fuel WHERE gasStationId = :gasStationId AND fuelName = :fuelName")
    fun getGasStationFuel(gasStationId: Int, fuelName: String): List<Fuel>

    @Query("SELECT * FROM Fuel WHERE gasStationId = :gasStationId")
    fun getGasStationFuels(gasStationId: Int): List<Fuel>

    @Transaction
    @Query("SELECT * FROM gasstation WHERE gasstation.id = :idGasStation")
    fun getGasStationAndFuels(idGasStation: Int): GasStationAndFuels

    @Transaction
    @Insert
    fun insertGasStationAndFuels(gasStationAndFuels: GasStationAndFuels) {
        val gasStationId = insertGasStation(gasStation = gasStationAndFuels.gasStation)
        for (fuel in gasStationAndFuels.fuels) {
            insertFuel(fuel.clone(/*gasStationId = gasStationId.toInt()*/))
        }
    }

}