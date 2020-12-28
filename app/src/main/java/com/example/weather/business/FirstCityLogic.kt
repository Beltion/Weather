package com.example.weather.business

import com.example.core.business.BasePresenter
import com.example.core.business.BaseView
import com.example.weather.frameworks.room.CityWeatherDAO

// This Activity calls when app first start or User city.count == 0

interface FirstCityPresenter : BasePresenter {
    fun initView(v: FirstCityView)
    fun onBtnClick(cityTitle: String)
}

interface FirstCityView : BaseView {
    fun getCityName() : String
    fun getStringFromID(stringID: Int) : String
    fun showToast(str: String)
    fun startNewActivity()
    fun getDataBaseDAO() : CityWeatherDAO
    fun showCancelBtn()
}
