package com.example.core.business.entities

data class Clouds(
        val all: Int
)

data class Snow(
        val atHour: Float
)

data class Coordinate(
        val lon: String,
        val Lat: String
)


data class MainWeatherData(
        val temp: Float,
        val feels_like: Float,
        val temp_min: Float,
        val temp_max: Float,
        val pressure: Float,
        val humidity: Int
)

data class SystemCityData(
        val type: Int,
        val id: Int,
        val country: String,
        val sunrise: Int,
        val sunset: Int
)

data class Weather(
     val id: Int,
     val main: String,
     val description: String,
     val icon: String
)

data class Wind(
        val speed: Int,
        val deg: Int
)