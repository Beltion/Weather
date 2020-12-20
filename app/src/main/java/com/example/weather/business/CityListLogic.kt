package com.example.weather.business

import com.example.core.business.BasePresenter
import com.example.core.business.BaseView
import com.example.core.business.entities.Coordinate
import com.example.weather.data.entities.CityWeather
import com.example.weather.data.entities.CityWeatherParcelable
import com.example.weather.data.entities.parcelable.CoordinateParcelable

//  This Activity calls when User save one or more city

interface CityListPresenter : BasePresenter {
    fun initView(v: CityListView)
    fun onItemClick(cityTitle: String)
    fun onItemLongClick()
}

interface CityListView : BaseView {
    fun initRV(citiesWeather: ArrayList<CityWeather>?)
    fun getStringFromID(stringID: Int) : String
    fun showToast(str: String)
    fun getCityWeatherParcelable() : CityWeatherParcelable?
    fun startForecastActivity(coordinate: CoordinateParcelable)
    fun startFirstCityActivity()
}