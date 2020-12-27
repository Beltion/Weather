package com.example.weather.frameworks

import android.util.Log
import com.example.core.business.entities.WeekCityWeatherClassInterface
import com.example.core.data.week_city.WeekCityDataSource
import com.example.weather.data.entities.json.CityWeatherErrorBody
import com.example.weather.data.entities.json.WeekCityWeatherRetrofit
import com.google.gson.Gson
import kotlinx.coroutines.*
import retrofit2.Response

class WeekCityWeatherApiDS: WeekCityDataSource {

    private val TAG = WeekCityWeatherApiDS::class.simpleName
    private val job = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.IO + job)

    override suspend fun getWeekWeather(city: String): WeekCityWeatherClassInterface?
            = GlobalScope.async(scope.coroutineContext) {
            Log.d(TAG, "Start Coroutine: $coroutineContext")
            var weekCityWeatherRetrofit: WeekCityWeatherRetrofit? = null

            val job = async {
                Common.retrofitService.getWeekWeatherCo(city)
            }

            val response: Response<WeekCityWeatherRetrofit>
                    = job.await()
            if (response.isSuccessful && response.body() != null){
                Log.d(TAG, "Response: ${response.body()}")
                weekCityWeatherRetrofit = response.body()
                return@async weekCityWeatherRetrofit
            } else {
                try {
                    return@async Gson().fromJson(
                            response.errorBody().toString(),
                            CityWeatherErrorBody::class.java
                    )
                } catch (e: Exception){
                    e.printStackTrace()
                    return@async null
                }
            }
        }.await()

}
