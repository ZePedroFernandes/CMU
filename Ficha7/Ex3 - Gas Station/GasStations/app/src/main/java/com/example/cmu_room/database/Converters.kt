package com.example.cmu_room.database

import androidx.room.TypeConverter
import java.sql.Timestamp

class Converters {

    @TypeConverter
    fun dateToTimestamp(date: Timestamp?): Long? {
        return Timestamp.valueOf(date.toString()).time
    }

    @TypeConverter
    fun fromTimestamp(value: Long?): Timestamp? {
        value?.let {
            return Timestamp(value)
        }
        return null
    }
}