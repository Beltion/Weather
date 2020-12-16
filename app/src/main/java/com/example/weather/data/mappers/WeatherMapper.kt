package com.example.weather.data.mappers

import android.os.Parcel
import com.example.core.business.entities.Weather
import com.example.weather.data.entities.CityWeather
import com.example.weather.data.entities.CityWeatherParcelable
import com.example.weather.data.entities.parcelable.*

class WeatherMapper {
    fun cityWeatherToParcelable(cityWeather: CityWeather)
            = CityWeatherParcelable(
            cityWeather.cod,
            cityWeather.base,
            cityWeather.visibility,
            cityWeather.dt,
            cityWeather.timezone,
            cityWeather.id,
            cityWeather.name,
            CoordinateParcelable(
                    cityWeather.coord.lon,
                    cityWeather.coord.lat
            ),
            weatherListToWeatherParcelableList(cityWeather.weather),
            MainWeatherDataParcelable(
                    cityWeather.main.temp,
                    cityWeather.main.feels_like,
                    cityWeather.main.temp_min,
                    cityWeather.main.temp_max,
                    cityWeather.main.pressure,
                    cityWeather.main.humidity
            ),
            WindParcelable(
                    cityWeather.wind.speed,
                    cityWeather.wind.deg
            ),
            SnowParcelable(
                   cityWeather.let{
                       it.snow.atHour
                   } ?: 0.0f // <- set 0 if weather haven't snow
            ),
            CloudsParcelable(
                    cityWeather.clouds.all
            ),
            SystemCityDataParcelable(
                    cityWeather.sys.type,
                    cityWeather.sys.id,
                    cityWeather.sys.country,
                    cityWeather.sys.sunrise,
                    cityWeather.sys.sunset
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