package com.example.weather.business

import com.example.core.business.BasePresenter
import com.example.core.business.BaseView
import com.example.core.business.entities.CityWeather
import com.example.weather.data.entities.parcelable.CityParcelable
import com.example.weather.frameworks.room.CityWeatherDAO

//  This Activity calls when User save one or more city

interface CityListPresenter : BasePresenter {
    fun initView(v: CityListView)
    fun onItemClick(cityTitle: CityWeather)
    fun onItemLongClick(cityWeather: CityWeather)
}

interface CityListView : BaseView {
    fun initRV(citiesWeather: ArrayList<CityWeather>)
    fun getStringFromID(stringID: Int) : String
    fun showToast(str: String)
    fun startForecastActivity(city: String)
    fun startFirstCityActivity()
    fun getDataBaseDAO() : CityWeatherDAO
}