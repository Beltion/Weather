package com.example.core.data.week_city

import com.example.core.business.entities.WeekCityWeather

interface WeekCityWeatherRepository {
    fun getWeekWeather(city: String): WeekCityWeather
}