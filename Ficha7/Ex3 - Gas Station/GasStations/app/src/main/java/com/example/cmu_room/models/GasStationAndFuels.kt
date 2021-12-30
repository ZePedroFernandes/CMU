package com.example.cmu_room.models

import androidx.room.Embedded
import androidx.room.Relation
import java.io.Serializable

class GasStationAndFuels(
    @Embedded
    val gasStation: GasStation,
    @Relation(
        parentColumn = "id",
        entityColumn = "gasStationId"
    )
    val fuels: List<Fuel>
) : Serializable