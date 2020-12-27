package com.example.weather.frameworks.room.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull


@Entity(tableName = "cities")
class CityTableEntity (
    @PrimaryKey @NotNull @ColumnInfo(name = "cityName") val cityName: String
)