package com.example.core.data.all_city

import com.example.core.business.callbacks.FailureCallback
import com.example.core.business.callbacks.SuccessCallback
import com.example.core.business.entities.CityWeather

interface AllCityWeatherRepository {
    suspend fun getAllCityWeatherToday(successCallback: SuccessCallback,
                                       failureCallback: FailureCallback
    )

    suspend fun deleteCityWeatherToday(cityWeather: CityWeather,
                                       successCallback: SuccessCallback,
                                       failureCallback: FailureCallback
    )

    suspend fun insertCityWeatherToday(cityWeather: CityWeather,
                                       successCallback: SuccessCallback,
                                       failureCallback: FailureCallback
    )
}