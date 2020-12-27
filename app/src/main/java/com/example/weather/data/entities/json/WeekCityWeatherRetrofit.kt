package com.example.weather.data.entities.json

import com.example.core.business.entities.City

data class WeekCityWeatherRetrofit(
        val cod: Int,
        val cty: City,
        val list: ArrayList<WeekCityWeatherListItem>
)