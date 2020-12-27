package com.example.core.data.city

import com.example.core.business.callbacks.FailureCallback
import com.example.core.business.callbacks.SuccessCallback
import com.example.core.business.entities.CityWeatherClassInterface

interface CityWeatherDataSource {

    suspend fun getWeatherToday(city: String): CityWeatherClassInterface?

    suspend fun getWeatherToday(city: String,
                                successCallback: SuccessCallback,
                                failureCallback: FailureCallback)
    suspend fun getWeatherForWeek(lat: Float,
                                  lon: Float,
                                  successCallback: SuccessCallback,
                                  failureCallback: FailureCallback)
}