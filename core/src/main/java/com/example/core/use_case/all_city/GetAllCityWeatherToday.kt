package com.example.core.use_case.all_city

import com.example.core.business.callbacks.FailureCallback
import com.example.core.business.callbacks.SuccessCallback
import com.example.core.data.all_city.AllCityWeatherRepository

class GetAllCityWeatherToday(private val repository: AllCityWeatherRepository) {
    suspend fun getCitiesWeatherToday(successCallback: SuccessCallback,
                                      failureCallback: FailureCallback){
        repository.getAllCityWeatherToday(
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