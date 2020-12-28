package com.example.weather.presentation.week_city

import android.util.Log
import com.example.weather.business.WeekCityPresenter
import com.example.weather.business.WeekCityView
import com.example.weather.data.entities.DayOfWeek
import com.example.weather.data.entities.ThreeHourAtDay
import com.example.weather.data.entities.json.WeekCityWeatherRetrofit
import com.example.weather.data.mappers.WeatherMapper
import kotlinx.coroutines.Dispatchers
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

    override fun onDayClick(day: Int) {
        Log.d(TAG, "Click on day: |$day|")
        val dayAtHour = ArrayList<ThreeHourAtDay>()
        for(dayOfWeek in model.days){
            if (dayOfWeek.dateDay == day){
                dayAtHour.addAll(dayOfWeek.weatherThreeHourEaches)
            }
        }
        Log.d(TAG, "Day at hour: $dayAtHour")
        view?.get()?.initDayHoursRV(dayAtHour)
    }

    override fun onViewCreated() {
        Log.d(TAG,"Before model.get")
        GlobalScope.launch(Dispatchers.Main) {
            view?.get()?.let{ view ->
                val weekCityWeather: WeekCityWeatherRetrofit?
                        = async {
                    model.getWeekWeather(
                        view.getParcelable()
                    )
                }.await()
                Log.d(TAG,"Model: $weekCityWeather")
                Log.d(TAG,"After model.get")

                if (weekCityWeather != null) {
                    val days: ArrayList<DayOfWeek> = WeatherMapper.cityWeekRetrofitToDayOfWeek(weekCityWeather)
                    for (day in days){
                        Log.d(TAG, day.dateDay.toString())
                        Log.d(TAG, day.dateMonth.toString())
                        Log.d(TAG, day.weatherThreeHourEaches.toString())
                    }
                    model.days.addAll(days)
                    Log.d(TAG,"Days: ${model.days.size}")
                    val intDays = model.getDays(model.days)
                    Log.d(TAG,"Days: ${weekCityWeather.city.name}")
                    view.setCityName(weekCityWeather.city.name)
                    view.initDaysRV(intDays)
                    view.showContent()
                }
            }


        }


    }
}