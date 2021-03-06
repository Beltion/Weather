package com.example.weather.presentation.week_city

import android.util.Log
import com.example.core.use_case.city.GetCityWeatherWeek
import com.example.weather.data.entities.DayOfWeek
import com.example.weather.data.entities.json.WeekCityWeatherRetrofit
import com.example.weather.data.repositories.WeekCityWeatherRepositoryApi
import com.example.weather.frameworks.Common
import kotlinx.coroutines.*
import retrofit2.Response


class WeekCityWeatherModel {

    private val job = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.IO + job)
    private val TAG = WeekCityWeatherModel::class.simpleName

    var days = ArrayList<DayOfWeek>()

    suspend fun getWeekWeather(city: String) : WeekCityWeatherRetrofit? {
        var weekCityWeatherRetrofit: WeekCityWeatherRetrofit? = null
        GlobalScope.async(scope.coroutineContext) {

            val response: Response<WeekCityWeatherRetrofit>
                    = async {
                Common.retrofitService.getWeekWeatherCo(city)
            }.await()
            if (response.isSuccessful && response.body() != null){
                weekCityWeatherRetrofit = response.body()
                Log.d(TAG, "Week weather Model return: $weekCityWeatherRetrofit")
            } else {
                weekCityWeatherRetrofit = null
            }
        }.await()

        return weekCityWeatherRetrofit
    }

    fun getDays(week: ArrayList<DayOfWeek>): ArrayList<Int> {
        val days = ArrayList<Int>()

        for (day in week){
            days.add(
                    day.dateDay
            )
        }

        return days
    }

}