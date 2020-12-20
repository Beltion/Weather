package com.example.weather.data.entities.room


//  This Class used when app work with today weather Room

data class CityWeather(
    val cityName: String,
    val date: String,// Time of data calculation, unix, UTC
    val main: String,// Group of weather parameters (Rain, Snow, Extreme etc.)
    val desc: String,//  Weather condition within the group.
    val icon: String,
    val lon: Float,//  City geo location, longitude
    val lat: Float,// City geo location, latitude
    val temp: Float,// Temperature in Kelvin
    val feelsLike: Float,// This temperature parameter accounts for the human perception of weather
    val pressure: Float,// Atmospheric pressure
    val humidity: Int,//  Humidity, %
    val windSpeed: String,// Wind speed. Unit Default: meter/sec
    val windDirection: String,// Wind direction, degrees (meteorological)
    val windGust: String,// Wind gust. Unit Default: meter/sec
    val clouds: String// Cloudiness, %
)