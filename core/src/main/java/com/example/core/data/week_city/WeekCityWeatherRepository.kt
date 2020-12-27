package com.example.core.data.week_city

import com.example.core.business.entities.WeakCityWeather

interface WeekCityWeatherRepository {
    fun getWeekWeather(city: String): WeakCityWeather
}