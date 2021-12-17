package com.example.cmu_room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cmu_room.models.Fuel
import com.example.cmu_room.models.GasStation
import java.util.concurrent.Executors

@Database(entities = [GasStation::class, Fuel::class], version = 1)
@TypeConverters(Converters::class)
abstract class GasStationDB : RoomDatabase() {

    abstract fun gasStationDao(): GasStationDao

    companion object {

        var instance: GasStationDB? = null

        val executors = Executors.newFixedThreadPool(2)

        fun getInstance(context: Context): GasStationDB? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    GasStationDB::class.java, "gas_station_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }

    }

}