package com.example.cmu_room.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.cmu_room.models.Fuel
import com.example.cmu_room.models.GasStation
import com.example.cmu_room.models.GasStationAndFuels


@Dao
interface GasStationDao {

    @Query("SELECT * FROM gasStation")
    fun getAll(): List<GasStation>

    @Query("SELECT * FROM gasStation WHERE gasStation.id = :id")
    fun getGasStation(id: Int): GasStation

    @Insert
    fun insertGasStation(gasStation: GasStation): Long

    @Insert
    fun insertFuel(fuel: Fuel)

    @Transaction
    @Query("SELECT * FROM gasStation WHERE gasStation.id = :idGasStation")
    fun getGasStationAndFuels(idGasStation: Int): GasStationAndFuels

    @Transaction
    @Insert
    fun insertGasStationAndFuels(gasStationAndFuels: GasStationAndFuels) {
        val gasStationId = insertGasStation(gasStation = gasStationAndFuels.gasStation)
        for (fuel in gasStationAndFuels.fuels) {
            insertFuel(fuel.copy(gasStationId = gasStationId.toInt()))
        }
    }

}