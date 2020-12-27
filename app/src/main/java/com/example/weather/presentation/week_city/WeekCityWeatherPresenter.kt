package com.example.weather.presentation.week_city

import android.util.Log
import com.example.weather.business.WeekCityPresenter
import com.example.weather.business.WeekCityView
import java.lang.ref.WeakReference

class WeekCityWeatherPresenter : WeekCityPresenter {

    private val TAG = WeekCityWeatherPresenter::class.simpleName

    private var view: WeakReference<WeekCityView>? = null
    private val model = WeekCityWeatherModel()

    override fun initView(v: WeekCityView) {
        view = WeakReference(v)
    }

    override fun onViewCreated() {
        Log.d(TAG,model.getWeekWeather().toString())
    }

}