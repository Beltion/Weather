package com.example.core.data.week_city

import com.example.core.business.entities.WeekCityWeatherClassInterface

interface WeekCityDataSource {
    suspend fun getWeekWeather(city: String): WeekCityWeatherClassInterface?
}