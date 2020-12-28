package com.example.weather.data.entities

import com.example.core.business.entities.Clouds
import com.example.core.business.entities.MainWeatherData
import com.example.core.business.entities.Weather
import com.example.core.business.entities.Wind
import com.example.weather.data.entities.json.Rain
import com.example.weather.data.entities.json.Snow

//  Weather data for three hours per day

data class ThreeHourAtDay(
        val time: String,
        val main: MainWeatherData,
        val weather: ArrayList<Weather>,
        val clouds: Clouds,
        val wind: Wind,
        val rain: Rain?,
        val snow: Snow?,
        val visibility: Int
)