package com.example.weather.business

import com.example.core.business.BasePresenter
import com.example.core.business.BaseView
import com.example.weather.data.entities.json.CityWeatherRetrofit
import com.example.weather.data.entities.parcelable.CityWeatherParcelable
import com.example.weather.data.entities.parcelable.CoordinateParcelable

//  This Activity calls when User save one or more city

interface CityListPresenter : BasePresenter {
    fun initView(v: CityListView)
    fun onItemClick(cityTitle: String)
    fun onItemLongClick()
}

interface CityListView : BaseView {
    fun initRV(citiesWeatherRetrofit: ArrayList<CityWeatherRetrofit>?)
    fun getStringFromID(stringID: Int) : String
    fun showToast(str: String)
    fun getCityWeatherParcelable() : CityWeatherParcelable?
    fun startForecastActivity(coordinate: CoordinateParcelable)
    fun startFirstCityActivity()
}