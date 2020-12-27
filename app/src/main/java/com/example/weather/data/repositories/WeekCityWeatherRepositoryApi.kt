package com.example.weather.data.repositories

import com.example.core.business.entities.WeekCityWeatherClassInterface
import com.example.core.data.week_city.WeekCityWeatherRepository
import com.example.weather.data.entities.json.WeekCityWeatherRetrofit
import com.example.weather.frameworks.WeekCityWeatherApiDS
import kotlinx.coroutines.*

class WeekCityWeatherRepositoryApi: WeekCityWeatherRepository {

    private val job = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.IO + job)
    private val apiDS = WeekCityWeatherApiDS()

    private val TAG = WeekCityWeatherRepositoryApi::class.simpleName

    override fun getWeekWeather(city: String): WeekCityWeatherClassInterface? {
        var weekCityWeather: WeekCityWeatherRetrofit? = null
        GlobalScope.async(scope.coroutineContext) {

            weekCityWeather = async {
                apiDS.getWeekWeather(city)
            }.await() as WeekCityWeatherRetrofit?

            return@async weekCityWeather
        }
        return weekCityWeather
    }
}