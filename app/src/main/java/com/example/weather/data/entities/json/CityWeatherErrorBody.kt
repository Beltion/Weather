package com.example.weather.data.entities.json

import com.example.core.business.entities.CityWeatherClassInterface
import com.example.core.business.entities.WeekCityWeatherClassInterface

data class CityWeatherErrorBody(
     val cod: String,
     val message: String
) : CityWeatherClassInterface, WeekCityWeatherClassInterface