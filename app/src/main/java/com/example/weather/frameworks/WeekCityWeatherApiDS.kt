package com.example.weather.frameworks

import android.util.Log
import com.example.core.business.entities.WeekCityWeather
import com.example.core.data.week_city.WeekCityDataSource
import com.example.weather.data.entities.json.CityWeatherErrorBody
import com.example.weather.data.entities.json.WeekCityWeatherRetrofit
import com.google.gson.Gson
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import retrofit2.Response

class WeekCityWeatherApiDS: WeekCityDataSource {

    private val TAG = WeekCityWeatherApiDS::class.simpleName

    override suspend fun getWeekWeather(city: String): WeekCityWeather? {
        var weekCityWeatherRetrofit: WeekCityWeatherRetrofit? = null

        coroutineScope {
            val job = async {
                Common.retrofitService.getWeekWeatherCo(city)
            }

            val response: Response<WeekCityWeatherRetrofit>
                    = job.await()
            if (response.isSuccessful && response.body() != null){
                Log.d(TAG, "Response: ${response.body()}")
                weekCityWeatherRetrofit = response.body()
                return@coroutineScope weekCityWeatherRetrofit
            } else {
                try {
                    return@coroutineScope Gson().fromJson(
                            response.errorBody().toString(),
                            CityWeatherErrorBody::class.java
                    )
                } catch (e: Exception){
                    e.printStackTrace()
                    return@coroutineScope null
                }
            }
        }

        return weekCityWeatherRetrofit
    }
}