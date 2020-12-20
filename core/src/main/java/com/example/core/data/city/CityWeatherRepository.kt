package com.example.core.data.city

import com.example.core.business.callbacks.FailureCallback
import com.example.core.business.callbacks.SuccessCallback

interface CityWeatherRepository{
    suspend fun getWeatherToday(city: String,
                                successCallback: SuccessCallback,
                                failureCallback: FailureCallback)
    suspend fun getWeatherForWeek(successCallback: SuccessCallback,
                                  failureCallback: FailureCallback)
}