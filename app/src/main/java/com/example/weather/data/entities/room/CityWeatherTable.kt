package com.example.weather.data.entities.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "cities")
class CityWeatherTable (
    @PrimaryKey @ColumnInfo(name = "name") val cityName: String,
    @ColumnInfo(name = "date") val date: String,// Time of data calculation, unix, UTC
    @ColumnInfo(name = "main") val main: String,// Group of weather parameters (Rain, Snow, Extreme etc.)
    @ColumnInfo(name = "desc") val desc: String,//  Weather condition within the group.
    @ColumnInfo(name = "icon") val icon: String,
    @ColumnInfo(name = "lon") val lon: Float,//  City geo location, longitude
    @ColumnInfo(name = "lat") val lat: Float,// City geo location, latitude
    @ColumnInfo(name = "temp") val temp: Float,// Temperature in Kelvin
    @ColumnInfo(name = "feels") val feelsLike: Float,// This temperature parameter accounts for the human perception of weather
    @ColumnInfo(name = "pressure") val pressure: Float,// Atmospheric pressure
    @ColumnInfo(name = "humidity") val humidity: Int,//  Humidity, %
    @ColumnInfo(name = "wind_speed") val windSpeed: String,// Wind speed. Unit Default: meter/sec
    @ColumnInfo(name = "wind_direction") val windDirection: String,// Wind direction, degrees (meteorological)
    @ColumnInfo(name = "clouds") val clouds: String// Cloudiness, %

)