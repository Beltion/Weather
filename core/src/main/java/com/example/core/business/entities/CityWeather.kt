package com.example.core.business.entities


//  This Class used when app work with today weather Room

data class CityWeather(
    val cityName: String,
    val date: Int,// Time of data calculation, unix, UTC
    val main: String,// Group of weather parameters (Rain, Snow, Extreme etc.)
    val desc: String,//  Weather condition within the group.
    val icon: String,
    val lon: String,//  City geo location, longitude
    val lat: String,// City geo location, latitude
    val temp: Float,// Temperature in Kelvin
    val feelsLike: Float,// This temperature parameter accounts for the human perception of weather
    val pressure: Float,// Atmospheric pressure
    val humidity: Int,//  Humidity, %
    val windSpeed: Float,// Wind speed. Unit Default: meter/sec
    val windDirection: Int,// Wind direction, degrees (meteorological)
    val clouds: Int// Cloudiness, %
)