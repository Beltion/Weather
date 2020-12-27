package com.example.weather.presentation.week_city

import android.util.Log
import com.example.weather.business.WeekCityPresenter
import com.example.weather.business.WeekCityView
import com.example.weather.data.entities.json.WeekCityWeatherRetrofit
import com.example.weather.data.mappers.WeatherMapper
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.lang.ref.WeakReference

class WeekCityWeatherPresenter : WeekCityPresenter {

    private val TAG = WeekCityWeatherPresenter::class.simpleName

    private var view: WeakReference<WeekCityView>? = null
    private val model = WeekCityWeatherModel()

    override fun initView(v: WeekCityView) {
        view = WeakReference(v)
    }

    override fun onViewCreated() {
        Log.d(TAG,"Before model.get")
        GlobalScope.launch {
            val weekCityWeather: WeekCityWeatherRetrofit?
                    = async {
                model.getWeekWeather()
            }.await()
            Log.d(TAG,"Model: $weekCityWeather")
            Log.d(TAG,"After model.get")

            if (weekCityWeather != null) {
                        val days = WeatherMapper.cityWeekRetrofitToDayOfWeek(weekCityWeather)
                Log.d(TAG,"Days: ${days.size}")
                for (day in days){
                    Log.d(TAG,"Day: ${day.dateDay}")
                    for(threeAtDay in day.weatherThreeHourEaches){
                        Log.d(TAG,"Time: ${threeAtDay.time}")
                    }

                }
            }

        }


    }

}