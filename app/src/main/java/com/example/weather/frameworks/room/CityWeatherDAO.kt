package com.example.weather.frameworks.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.weather.frameworks.room.table.CityTableEntity

@Dao
interface CityWeatherDAO {

    @Query("SELECT * FROM cities")
    suspend fun getCitiesWeather(): List<CityTableEntity>

    @Insert
    suspend fun insert(cityWeather: CityTableEntity)

    @Delete
    suspend fun delete(cityWeather: CityTableEntity)
}