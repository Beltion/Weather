package com.example.weather.data.entities.json

import com.example.core.business.entities.City
import com.example.core.business.entities.WeekCityWeatherClassInterface

data class WeekCityWeatherRetrofit(
        val cod: Int,
        val city: City,
        val list: ArrayList<WeekCityWeatherListItem>
) : WeekCityWeatherClassInterface