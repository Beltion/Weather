package com.example.weather.business

import com.example.core.business.BasePresenter
import com.example.core.business.BaseView

//  This Activity calls when User save one or more city

interface CityListPresenter : BasePresenter {
    fun initView(v: CityListView)
    fun onItemClick(cityTitle: String)
    fun onItemLongClick()
}

interface CityListView : BaseView {
    fun initRV()
    fun getCityName() : String
    fun getStringFromID(stringID: Int) : String
    fun showToast(str: String)
//    fun startNewActivity() TODO pass weather data list on week
}