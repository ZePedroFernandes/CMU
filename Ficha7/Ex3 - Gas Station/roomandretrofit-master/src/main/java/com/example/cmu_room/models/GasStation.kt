package com.example.cmu_room.models

import android.util.Log
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import java.io.Serializable

@Entity
data class GasStation(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val address: String = "",
    val latitude: Double= 0.0,
    val longitude: Double=0.0) :
    Serializable