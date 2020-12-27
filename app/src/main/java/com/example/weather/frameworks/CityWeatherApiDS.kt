package com.example.weather.frameworks

import android.util.Log
import com.example.core.business.callbacks.FailureCallback
import com.example.core.business.callbacks.SuccessCallback
import com.example.core.business.entities.CityWeatherClassInterface
import com.example.weather.data.entities.json.CityWeatherErrorBody
import com.example.weather.data.entities.json.CityWeatherRetrofit
import com.example.core.data.city.CityWeatherDataSource
import com.google.gson.Gson
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//  Get weather from api and check status code
class CityWeatherApiDS : CityWeatherDataSource {

    private val job = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.Main + job)
    private val TAG = CityWeatherApiDS::class.simpleName

    override suspend fun getWeatherToday(city: String): CityWeatherClassInterface? {
        var cityWeather: CityWeatherRetrofit? = null
        GlobalScope.async(scope.coroutineContext){
            val response: Response<CityWeatherRetrofit> = async {
                Common.retrofitService.getOneDayWeatherCo(city)
            }.await()
            if(response.isSuccessful && response.body() != null){
                Log.d(TAG, "Response: ${response.body()}")
                cityWeather = response.body()!!
                return@async cityWeather
            } else {
                try {
                    return@async Gson().fromJson(
                            response.errorBody()!!.string(),
                            CityWeatherErrorBody::class.java)
                } catch (e: Exception) {
                    e.printStackTrace()
                    return@async null
                }
            }
        }

        return cityWeather
    }

    override suspend fun getWeatherToday(
        city: String,
        successCallback: SuccessCallback,
        failureCallback: FailureCallback
    ) {
        try {
            val common = Common.retrofitService
            common.getOneDayWeather(city).enqueue(object : Callback<CityWeatherRetrofit>{
                override fun onFailure(call: Call<CityWeatherRetrofit>, t: Throwable) {
                    t.printStackTrace()
                    failureCallback.onFailure("$TAG Callback onFailure-> ", t)
                }

                override fun onResponse(call: Call<CityWeatherRetrofit>, response: Response<CityWeatherRetrofit>) {
                    if (response.isSuccessful){
                        successCallback.onSuccess(response.body())
                    } else {
                        try {
                            val error: CityWeatherErrorBody =
                                    Gson().fromJson(
                                            response.errorBody()!!.string(),
                                            CityWeatherErrorBody::class.java)
                            failureCallback.onFailure("$TAG errorBody-> ", error)
                        } catch (e: Exception) {
                            e.printStackTrace()
                            failureCallback.onFailure("$TAG errorBody exception-> ", e)
                        }
                    }
                }

            })
        } catch (e: Exception){
            e.printStackTrace()
            failureCallback.onFailure("$TAG -> ", e)
        }
    }

    override suspend fun getWeatherForWeek(
        lat: Float,
        lon: Float,
        successCallback: SuccessCallback,
        failureCallback: FailureCallback
    ) {
        try {

        } catch (e: Exception){
            e.printStackTrace()
            failureCallback.onFailure("$TAG -> ", e)
        }
    }



}

