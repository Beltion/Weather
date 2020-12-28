package com.example.weather.presentation.first_city

import com.example.core.business.callbacks.FailureCallback
import com.example.core.business.callbacks.SuccessCallback
import com.example.core.business.entities.CityWeather
import com.example.core.use_case.all_city.GetAllCityWeatherToday
import com.example.core.use_case.all_city.InsertToAllCityWeather
import com.example.core.use_case.city.GetCityWeatherToday
import com.example.weather.data.repositories.AllCityWeatherRepositoryRoom
import com.example.weather.data.repositories.CityWeatherRepositoryApi
import com.example.weather.frameworks.room.CityWeatherDAO
import kotlinx.coroutines.*

class FirstCityModel {
    private val job = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.Main + job)

    fun getWeather(city: String,
                   successCallback: SuccessCallback,
                   failureCallback: FailureCallback) = scope.launch {
        val getWeatherToday = GetCityWeatherToday(
            CityWeatherRepositoryApi()
        )
        getWeatherToday.getWeather(city,
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

    fun insertCityWeather(roomDS: CityWeatherDAO,
                          cityWeather: CityWeather,
                          successCallback: SuccessCallback,
                          failureCallback: FailureCallback) = scope.launch {
        val insertToAllCityWeather = InsertToAllCityWeather(AllCityWeatherRepositoryRoom(roomDS))

        insertToAllCityWeather.insert(
                cityWeather,
                object : SuccessCallback{
                    override fun onSuccess(data: Any?) {
                        successCallback.onSuccess(data)
                    }
                },  object : FailureCallback{
            override fun onFailure(tag: String, error: Any?) {
                failureCallback.onFailure(tag, error)
            }

        }
        )
    }

    fun getAllCityWeather(roomDS: CityWeatherDAO,
                          successCallback: SuccessCallback,
                          failureCallback: FailureCallback) = scope.launch {
        val getAllCityWeatherToday = GetAllCityWeatherToday(AllCityWeatherRepositoryRoom(roomDS))

        getAllCityWeatherToday.getCitiesWeatherToday(
            object : SuccessCallback {
                override fun onSuccess(data: Any?) {
                    successCallback.onSuccess(data)
                }

            },
            object : FailureCallback {
                override fun onFailure(tag: String, error: Any?) {
                    failureCallback.onFailure(tag, error)
                }

            }
        )
    }
}