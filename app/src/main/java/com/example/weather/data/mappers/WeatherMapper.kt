package com.example.weather.data.mappers

import com.example.core.business.entities.Weather
import com.example.weather.data.entities.json.CityWeatherRetrofit
import com.example.weather.data.entities.parcelable.CityWeatherParcelable
import com.example.weather.data.entities.parcelable.*
import com.example.core.business.entities.CityWeather

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

        fun cityWeatherParcelableToCityWeather(cityWeatherParcelable: CityWeatherParcelable)
                = CityWeather(
                cityWeatherParcelable.name ?: "",
                cityWeatherParcelable.dt,
                cityWeatherParcelable.weather[0].main ?: "",
                cityWeatherParcelable.weather[0].description ?: "",
                cityWeatherParcelable.weather[0].icon ?: "",
                cityWeatherParcelable.coord?.lon ?: "",
                cityWeatherParcelable.coord?.lat ?: "",
                cityWeatherParcelable.main?.temp ?: 0.0f,
                cityWeatherParcelable.main?.feelsLike ?: 0.0f,
                cityWeatherParcelable.main?.pressure ?: 0.0f,
                cityWeatherParcelable.main?.humidity ?: 0,
                cityWeatherParcelable.wind?.speed ?: 0.0f,
                cityWeatherParcelable.wind?.deg ?: 0,
                cityWeatherParcelable.clouds?.all ?: 0
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