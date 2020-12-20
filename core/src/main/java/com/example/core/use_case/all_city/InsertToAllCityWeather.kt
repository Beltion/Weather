package com.example.core.use_case.all_city

import com.example.core.business.callbacks.FailureCallback
import com.example.core.business.callbacks.SuccessCallback
import com.example.core.business.entities.CityWeather
import com.example.core.data.all_city.AllCityWeatherRepository

class InsertToAllCityWeather(private val repository: AllCityWeatherRepository) {
    suspend fun insert(cityWeather: CityWeather,
                       successCallback: SuccessCallback,
                       failureCallback: FailureCallback){
        repository.insertCityWeatherToday(cityWeather,
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