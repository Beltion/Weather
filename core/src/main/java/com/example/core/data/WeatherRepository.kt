package com.example.core.data

import com.example.core.business.callbacks.FailureCallback
import com.example.core.business.callbacks.SuccessCallback

interface WeatherRepository{
    suspend fun getWeatherToday(successCallback: SuccessCallback,
                                failureCallback: FailureCallback)
    suspend fun getWeatherForWeek(successCallback: SuccessCallback,
                                  failureCallback: FailureCallback)
}