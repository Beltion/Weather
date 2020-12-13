package com.example.core.business.entities

data class CityWeather(
        val code: Int,
        val base: String,
        val visibility: String,
        val dt: Int,
        val timezone: Int,
        val id: Int,
        val name: String,
        val coordinate: Coordinate, //  latitude and longitude of the city
        val weather: ArrayList<Weather>, //    More info Weather condition codes
        val main: MainWeatherData,
        val wind: Wind,
        val snow: Snow,
        val clouds: Clouds,
        val sys: SystemCityData
)