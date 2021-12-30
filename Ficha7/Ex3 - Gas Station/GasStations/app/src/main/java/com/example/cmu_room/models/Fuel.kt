package com.example.cmu_room.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.time.LocalDateTime

@Entity
data class Fuel(
    val fuelName: String,
    val price: Double,
    val date: LocalDateTime,
    val gasStationId: Int,
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
) : Serializable {

    fun clone(
//        gasStationId: Int = this.gasStationId,
//        fuelName: String = this.fuelName,
//        price: Double = this.price
    ) = Fuel(this.fuelName, this.price, this.date, this.gasStationId, this.id)

}
