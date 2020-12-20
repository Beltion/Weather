package com.example.weather.frameworks.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.weather.data.entities.room.CityWeather

@Dao
interface CityWeatherDAO {

    @Query("SELECT * FROM cities")
    suspend fun getCityWeather(): List<CityWeather>

    @Insert
    suspend fun insert(cityWeather: CityWeather)

    @Delete
    suspend fun delete(cityWeather: CityWeather)
}