package com.example.weather.presentation.week_city

import android.util.Log
import com.example.core.business.entities.WeekCityWeatherClassInterface
import com.example.core.use_case.city.GetCityWeatherWeek
import com.example.weather.data.entities.json.WeekCityWeatherRetrofit
import com.example.weather.data.repositories.WeekCityWeatherRepositoryApi

class WeekCityWeatherModel {

    private val TAG = WeekCityWeatherModel::class.simpleName

    fun getWeekWeather(city: String = "Ростов") : WeekCityWeatherClassInterface? {
        val getWeekCityWeather = GetCityWeatherWeek(WeekCityWeatherRepositoryApi())
        Log.d(TAG, "Week weather before return")
        return getWeekCityWeather.getWeekWeather(city)
    }

}