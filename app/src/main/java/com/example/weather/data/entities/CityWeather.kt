package com.example.weather.data.entities

import com.example.core.business.entities.*

// GSON parse  weather entity for Retrofit
// Should be in core but because child class have SerializedName can't be there
data class CityWeather(
        val cod: Int,
        val base: String,
        val visibility: String,
        val dt: Int,
        val timezone: Int,
        val id: Int,
        val name: String,
        val coord: Coordinate, //  latitude and longitude of the city
        val weather: ArrayList<Weather>, //    More info Weather condition codes
        val main: MainWeatherData,
        val wind: Wind,
        val snow: Snow?, //   <- have SerializedName annotation
        val rain: Rain?, //   <- have SerializedName annotation
        val clouds: Clouds,
        val sys: SystemCityData
)