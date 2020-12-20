package com.example.weather.data.repositories

import com.example.core.business.callbacks.FailureCallback
import com.example.core.business.callbacks.SuccessCallback
import com.example.core.data.city.CityWeatherRepository
import com.example.weather.frameworks.CityWeatherApiDS

class CityWeatherRepositoryApiImpl :
    CityWeatherRepository {

    private val TAG = CityWeatherRepositoryApiImpl::class.simpleName
    private val apiDS = CityWeatherApiDS()

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