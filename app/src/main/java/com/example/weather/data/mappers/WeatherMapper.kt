package com.example.weather.data.mappers

import com.example.core.business.entities.Weather
import com.example.weather.data.entities.json.CityWeatherRetrofit
import com.example.weather.data.entities.parcelable.CityWeatherParcelable
import com.example.weather.data.entities.parcelable.*
import com.example.weather.data.entities.room.CityWeather

class WeatherMapper {
    fun cityWeatherToParcelable(cityWeatherRetrofit: CityWeatherRetrofit)
            = CityWeatherParcelable(
            cityWeatherRetrofit.cod,
            cityWeatherRetrofit.base,
            cityWeatherRetrofit.visibility,
            cityWeatherRetrofit.dt,
            cityWeatherRetrofit.timezone,
            cityWeatherRetrofit.id,
            cityWeatherRetrofit.name,
            CoordinateParcelable(
                    cityWeatherRetrofit.coord.lon,
                    cityWeatherRetrofit.coord.lat
            ),
            weatherListToWeatherParcelableList(cityWeatherRetrofit.weather),
            MainWeatherDataParcelable(
                    cityWeatherRetrofit.main.temp,
                    cityWeatherRetrofit.main.feels_like,
                    cityWeatherRetrofit.main.temp_min,
                    cityWeatherRetrofit.main.temp_max,
                    cityWeatherRetrofit.main.pressure,
                    cityWeatherRetrofit.main.humidity
            ),
            WindParcelable(
                    cityWeatherRetrofit.wind.speed,
                    cityWeatherRetrofit.wind.deg
            ),
            SnowParcelable(
                    cityWeatherRetrofit.snow?.atHour ?: 0.0f // <- set 0 if weather haven't snow
            ),
            RainParcelable(
                    cityWeatherRetrofit.rain?.atHour ?: 0.0f // <- set 0 if weather haven't snow
            ),
            CloudsParcelable(
                    cityWeatherRetrofit.clouds.all
            ),
            SystemCityDataParcelable(
                    cityWeatherRetrofit.sys.type,
                    cityWeatherRetrofit.sys.id,
                    cityWeatherRetrofit.sys.country,
                    cityWeatherRetrofit.sys.sunrise,
                    cityWeatherRetrofit.sys.sunset
            )
    )


    fun weatherListToWeatherParcelableList(list: ArrayList<Weather>): ArrayList<WeatherParcelable> {
        val parcelables = ArrayList<WeatherParcelable>()

        list.forEach {
            parcelables.add(
                    WeatherParcelable(
                            it.id,
                            it.main,
                            it.description,
                            it.icon
                    )
            )
        }
        return parcelables
    }
}