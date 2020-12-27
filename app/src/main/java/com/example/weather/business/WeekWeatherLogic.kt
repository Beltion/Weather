package com.example.weather.business

import com.example.core.business.BasePresenter
import com.example.core.business.BaseView
import com.example.weather.frameworks.room.CityWeatherDAO

interface WeekCityPresenter : BasePresenter {
    fun initView(v: WeekCityView)
}

interface WeekCityView : BaseView {
    fun getStringFromID(stringID: Int) : String
    fun showToast(str: String)

}