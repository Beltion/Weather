package com.example.weather.data.repositories

import com.example.core.business.callbacks.FailureCallback
import com.example.core.business.callbacks.SuccessCallback
import com.example.core.business.entities.CityWeather
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
                    successCallback.onSuccess(data)
                }

            },  object :FailureCallback{
                    override fun onFailure(tag: String, error: Any?) {
                        failureCallback.onFailure(tag, error)
                    }

                })
        } catch (e: Exception){
            failureCallback.onFailure("$TAG ->1 ", e)
        }
    }

    override suspend fun getWeatherForWeek(
        successCallback: SuccessCallback,
        failureCallback: FailureCallback
    ) {
        TODO("Not yet implemented")
    }
}