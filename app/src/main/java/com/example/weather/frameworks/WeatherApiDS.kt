package com.example.weather.frameworks

import android.util.Log
import com.example.core.business.callbacks.FailureCallback
import com.example.core.business.callbacks.SuccessCallback
import com.example.core.business.entities.CityWeather
import com.example.core.data.WeatherDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class WeatherApiDS : WeatherDataSource {

    private val TAG = WeatherApiDS::class.simpleName

    override suspend fun getWeatherToday(
        city: String,
        successCallback: SuccessCallback,
        failureCallback: FailureCallback
    ) {
        try {
            val common = Common.retrofitService
            common.getOneDayWeather(city).enqueue(object : Callback<CityWeather>{
                override fun onFailure(call: Call<CityWeather>, t: Throwable) {
                    t.printStackTrace()
                    failureCallback.onFailure("$TAG Callback onFailure-> ", t.message)
                }

                override fun onResponse(call: Call<CityWeather>, response: Response<CityWeather>) {
                    if (response.isSuccessful){
                        successCallback.onSuccess(response.body())
                    } else {
                        try {
                            failureCallback.onFailure("$TAG errorBody-> ", response.errorBody())
                        } catch (e: Exception) {
                            e.printStackTrace()
                            failureCallback.onFailure("$TAG errorBody exception-> ", e.message)
                        }
                    }
                }

            })
        } catch (e: Exception){
            e.printStackTrace()
            failureCallback.onFailure("$TAG -> ", e.message)
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
            failureCallback.onFailure("$TAG -> ", e.message)
        }
    }

    interface WeatherApi {
        @GET("weather?")
        fun getOneDayWeather(
            @Query("q") city: String,
            @Query("lang") lang: String = "ru",
            @Query("appid") key: String = "51d4575d9c8e6d6decb5854c1db07ec7"
        ) : Call<CityWeather>

        @GET("onecall/timemachine?")
        fun getFiveDayWeather(
            @Query("lat") lat: String,
            @Query("lon") lon: String,
            @Query("dt") dt: String,
            @Query("lang") lang: String = "ru",
            @Query("appid") key: String = "51d4575d9c8e6d6decb5854c1db07ec7"
        ) : Call<CityWeather>
    }

    object RetrofitClient {
        private var retrofit: Retrofit? = null
        fun getRetrofitClient(baseUrl: String): Retrofit {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
    }

    object Common {
        private val BASE_URL = "https://api.openweathermap.org/data/2.5/"
        val retrofitService: WeatherApi
            get() = RetrofitClient.getRetrofitClient(BASE_URL).create(WeatherApi::class.java)

    }

}

