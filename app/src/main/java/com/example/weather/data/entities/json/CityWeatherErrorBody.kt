package com.example.weather.data.entities.json

import com.example.core.business.entities.CityWeatherToday

data class CityWeatherErrorBody(
     val cod: String,
     val message: String
) : CityWeatherToday