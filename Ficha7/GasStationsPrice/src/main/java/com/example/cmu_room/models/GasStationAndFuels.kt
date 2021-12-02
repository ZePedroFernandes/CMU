package com.example.cmu_room.models

import androidx.room.Embedded
import androidx.room.Relation
import com.example.cmu_room.models.GasStation

class GasStationAndFuels (
    @Embedded
    val gasStation: GasStation,
    @Relation(
        parentColumn = "id",
        entityColumn = "gasStationId"
    )
    val fuels : List<Fuel>
)