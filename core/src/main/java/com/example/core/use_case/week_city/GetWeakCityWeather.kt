package com.example.core.use_case.week_city

import com.example.core.business.entities.WeakCityWeather
import com.example.core.data.week_city.WeekCityWeatherRepository

class GetWeakCityWeather(private val repository: WeekCityWeatherRepository) {
    fun getWeekWeather(city: String): WeakCityWeather
            = repository.getWeekWeather(city)
}