package com.example.weather.business

import com.example.core.business.BasePresenter
import com.example.core.business.BaseView
import com.example.weather.data.entities.ThreeHourAtDay
import com.example.weather.data.entities.json.WeekCityWeatherRetrofit
import com.example.weather.frameworks.room.CityWeatherDAO

interface WeekCityPresenter : BasePresenter {
    fun initView(v: WeekCityView)
    fun onDayClick(day: Int)
}

interface WeekCityView : BaseView {
    fun getStringFromID(stringID: Int) : String
    fun showToast(str: String)
    fun initDaysRV(days: ArrayList<Int>)
    fun initDayHoursRV(daysAtHours: ArrayList<ThreeHourAtDay>)
    fun setCityName(name: String)
    fun getParcelable(): String
}