package com.example.weather.data.repositories

import com.example.core.business.callbacks.FailureCallback
import com.example.core.business.callbacks.SuccessCallback
import com.example.core.business.entities.CityWeather
import com.example.core.data.all_city.AllCityWeatherRepository
import com.example.weather.data.mappers.WeatherMapper
import com.example.weather.frameworks.room.CityWeatherDAO
import com.example.weather.frameworks.room.table.CityTableEntity
import java.lang.Exception

class AllCityWeatherRepositoryRoom(private val roomDS: CityWeatherDAO) : AllCityWeatherRepository{

    private val TAG = AllCityWeatherRepositoryRoom::class.simpleName


    override suspend fun getAllCityWeatherToday(
        successCallback: SuccessCallback,
        failureCallback: FailureCallback
    ) {
        try {
            val citiesWeather: List<CityTableEntity> = roomDS.getCitiesWeather()
            successCallback.onSuccess(citiesWeather)
        } catch (e: Exception) {
            e.printStackTrace()
            failureCallback.onFailure("$TAG -> ", e.message)
        }
    }

    override suspend fun deleteCityWeatherToday(
        cityWeather: CityWeather,
        successCallback: SuccessCallback,
        failureCallback: FailureCallback
    ) {
        try {
            roomDS.delete(
                    WeatherMapper.cityWeatherToCityTableEntity(cityWeather)
            )
            successCallback.onSuccess(true)
        } catch (e: Exception) {
            e.printStackTrace()
            failureCallback.onFailure("$TAG -> ", e.message)
        }
    }

    override suspend fun insertCityWeatherToday(
        cityWeather: CityWeather,
        successCallback: SuccessCallback,
        failureCallback: FailureCallback
    ) {
        try {
            roomDS.insert(
                    WeatherMapper.cityWeatherToCityTableEntity(cityWeather)
            )
            successCallback.onSuccess(true)
        } catch (e: Exception) {
            e.printStackTrace()
            failureCallback.onFailure("$TAG -> ", e.message)
        }
    }
}