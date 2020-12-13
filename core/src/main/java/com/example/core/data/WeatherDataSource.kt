package com.example.core.data

import com.example.core.business.callbacks.FailureCallback
import com.example.core.business.callbacks.SuccessCallback

interface WeatherDataSource {
    suspend fun getWeatherToday(successCallback: SuccessCallback,
                                failureCallback: FailureCallback,
                                city: String)
    suspend fun getWeatherForWeek(successCallback: SuccessCallback,
                                  failureCallback: FailureCallback,
                                  lat: Float,
                                  lon: Float)
}