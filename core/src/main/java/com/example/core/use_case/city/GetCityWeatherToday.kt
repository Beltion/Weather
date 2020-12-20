package com.example.core.use_case.city

import com.example.core.business.callbacks.FailureCallback
import com.example.core.business.callbacks.SuccessCallback
import com.example.core.data.city.CityWeatherRepository

class GetCityWeatherToday(private val repository: CityWeatherRepository) {
    suspend fun getWeather(city: String,
                           successCallback: SuccessCallback,
                           failureCallback: FailureCallback){
        repository.getWeatherToday(
            city,
            object : SuccessCallback{
                override fun onSuccess(data: Any?) {
                    successCallback.onSuccess(data)
                }

            },
            object : FailureCallback{
                override fun onFailure(tag: String, error: Any?) {
                    failureCallback.onFailure(tag, error)
                }

            }
        )
    }
}