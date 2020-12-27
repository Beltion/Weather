package com.example.weather.data.repositories

import android.util.Log
import com.example.core.business.entities.WeekCityWeatherClassInterface
import com.example.core.data.week_city.WeekCityWeatherRepository
import com.example.weather.data.entities.json.WeekCityWeatherRetrofit
import com.example.weather.frameworks.WeekCityWeatherApiDS
import kotlinx.coroutines.*

class WeekCityWeatherRepositoryApi: WeekCityWeatherRepository {

    private val job = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.Main + job)
    private val apiDS = WeekCityWeatherApiDS()

    private val TAG = WeekCityWeatherRepositoryApi::class.simpleName

    override fun getWeekWeather(city: String): WeekCityWeatherClassInterface? {
        var weekCityWeather: WeekCityWeatherRetrofit? = null
        GlobalScope.launch(scope.coroutineContext) {
            weekCityWeather = async {
                apiDS.getWeekWeather(city)
            }.await() as WeekCityWeatherRetrofit?
            Log.d(TAG, "Start Coroutine")
        }
        return weekCityWeather
    }
}