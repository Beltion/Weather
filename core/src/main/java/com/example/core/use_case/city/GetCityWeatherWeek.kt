package com.example.core.use_case.city

import com.example.core.data.week_city.WeekCityWeatherRepository

class GetCityWeatherWeek(private val repository: WeekCityWeatherRepository) {
    fun getWeekWeather(city: String)
            =repository.getWeekWeather(city)
}