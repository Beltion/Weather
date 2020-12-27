package com.example.core.business.entities

//  This entities used in CityWeatherRetrofit for JSON parse

data class Clouds(
        val all: Int
)

data class Coordinate(
        val lon: String,
        val lat: String
)

data class City(
        val name: String
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
        val speed: Float,
        val deg: Int
)