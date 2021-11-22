package com.example.cmu_room.database

import androidx.room.TypeConverter
import java.sql.Timestamp
import java.time.LocalDate
import java.time.LocalDateTime

class Converters {

    @TypeConverter
    fun dateToTimestamp(date: LocalDateTime?): Long? {
        return Timestamp.valueOf(date.toString()).time
    }

    @TypeConverter
    fun fromTimestamp(value: Long?): LocalDateTime? {
        value?.let {
            return LocalDateTime.parse(Timestamp(value).toString())
        }
        return null
    }
}