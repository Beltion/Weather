package com.example.weather.frameworks

import com.example.weather.data.entities.json.CityWeatherRetrofit
import com.example.weather.data.entities.json.WeekCityWeatherRetrofit
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather?")
    fun getOneDayWeather(
            @Query("q") city: String,
            @Query("lang") lang: String = "ru",
            @Query("appid") key: String = "51d4575d9c8e6d6decb5854c1db07ec7"
    ) : Call<CityWeatherRetrofit>

    @GET("weather?")
    suspend fun getOneDayWeatherCo(
            @Query("q") city: String,
            @Query("lang") lang: String = "ru",
            @Query("appid") key: String = "51d4575d9c8e6d6decb5854c1db07ec7"
    ) : Response<CityWeatherRetrofit>

    @GET("forecast?")
    suspend fun getWeekWeatherCo(
            @Query("q") city: String,
            @Query("lang") lang: String = "ru",
            @Query("appid") key: String = "51d4575d9c8e6d6decb5854c1db07ec7"
    ) : Response<WeekCityWeatherRetrofit>

    @GET("onecall/timemachine?")
    fun getFiveDayWeather(
            @Query("lat") lat: String,
            @Query("lon") lon: String,
            @Query("dt") dt: String,
            @Query("lang") lang: String = "ru",
            @Query("appid") key: String = "51d4575d9c8e6d6decb5854c1db07ec7"
    ) : Call<CityWeatherRetrofit>
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