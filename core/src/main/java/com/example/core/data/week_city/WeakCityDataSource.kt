package com.example.core.data.week_city

import com.example.core.business.entities.WeakCityWeather

interface WeakCityDataSource {
    suspend fun getWeekWeather(city: String): WeakCityWeather
}