package com.example.weather.data.repositories

import com.example.core.business.callbacks.FailureCallback
import com.example.core.business.callbacks.SuccessCallback
import com.example.core.data.WeatherRepository
import com.example.weather.frameworks.WeatherApiDS

class WeatherRepositoryImpl : WeatherRepository {

    private val TAG = WeatherRepositoryImpl::class.simpleName
    private val apiDS = WeatherApiDS()

    override suspend fun getWeatherToday(
        city: String,
        successCallback: SuccessCallback,
        failureCallback: FailureCallback
    ) {
        try {
            apiDS.getWeatherToday(city,
            object : SuccessCallback{
                override fun onSuccess(data: Any?) {
                    if (data != null){
                        successCallback.onSuccess(data)
                    } else {
                        failureCallback.onFailure("$TAG -> ", "data is null")
                    }
                }

            },  object :FailureCallback{
                    override fun onFailure(tag: String, error: Any?) {
                        failureCallback.onFailure(tag, error)
                    }

                })
        } catch (e: Exception){
            failureCallback.onFailure("$TAG -> ", e)
        }
    }

    override suspend fun getWeatherForWeek(
        successCallback: SuccessCallback,
        failureCallback: FailureCallback
    ) {
        TODO("Not yet implemented")
    }
}