package com.example.weather.presentation.first_city

import com.example.core.business.callbacks.FailureCallback
import com.example.core.business.callbacks.SuccessCallback
import com.example.core.use_case.city.GetCityWeatherToday
import com.example.weather.data.repositories.CityWeatherRepositoryApiImpl
import kotlinx.coroutines.*

class FirstCityModel {
    private val job = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.Main + job)

    fun getWeather(city: String,
                   successCallback: SuccessCallback,
                   failureCallback: FailureCallback) = scope.launch {
        val getWeatherToday = GetCityWeatherToday(
            CityWeatherRepositoryApiImpl()
        )
        getWeatherToday.getWeather(city,
            object : SuccessCallback{
                override fun onSuccess(data: Any?) {
                    successCallback.onSuccess(data)
                }

            },  object : FailureCallback{
                override fun onFailure(tag: String, error: Any?) {
                    failureCallback.onFailure(tag, error)
                }

            })
    }
}