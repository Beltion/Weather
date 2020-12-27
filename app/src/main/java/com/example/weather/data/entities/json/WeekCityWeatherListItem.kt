package com.example.weather.data.entities.json

import com.example.core.business.entities.Clouds
import com.example.core.business.entities.MainWeatherData
import com.example.core.business.entities.Weather
import com.example.core.business.entities.Wind

data class WeekCityWeatherListItem(
        val dt: Int,
        val main: MainWeatherData,
        val weather: Weather,
        val clouds: Clouds,
        val wind: Wind,
        val rain: Rain?,
        val snow: Snow?,
        val visibility: Int
)