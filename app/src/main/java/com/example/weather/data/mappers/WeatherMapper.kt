package com.example.weather.data.mappers

import android.util.Log
import com.example.core.business.entities.CityWeather
import com.example.weather.data.entities.json.CityWeatherRetrofit
import com.example.weather.frameworks.room.table.CityTableEntity


object WeatherMapper {
    fun cityWeatherRetrofitToCityWeather(cityWeatherRetrofit: CityWeatherRetrofit): CityWeather
            {
        Log.d("SSS", "CityWeather before add: ${CityWeather(
                cityName = cityWeatherRetrofit.name,
                date = cityWeatherRetrofit.dt,
                main = cityWeatherRetrofit.weather[0].main,
                desc = cityWeatherRetrofit.weather[0].description,
                icon = cityWeatherRetrofit.weather[0].icon,
                lon = cityWeatherRetrofit.coord.lon,
                lat = cityWeatherRetrofit.coord.lat,
                temp = cityWeatherRetrofit.main.temp,
                feelsLike = cityWeatherRetrofit.main.feels_like,
                pressure = cityWeatherRetrofit.main.pressure,
                humidity = cityWeatherRetrofit.main.humidity,
                windSpeed = cityWeatherRetrofit.wind.speed,
                windDirection = cityWeatherRetrofit.wind.deg,
                clouds = cityWeatherRetrofit.clouds.all
        )}")
        return CityWeather(
                cityName = cityWeatherRetrofit.name,
                date = cityWeatherRetrofit.dt,
                main = cityWeatherRetrofit.weather[0].main,
                desc = cityWeatherRetrofit.weather[0].description,
                icon = cityWeatherRetrofit.weather[0].icon,
                lon = cityWeatherRetrofit.coord.lon,
                lat = cityWeatherRetrofit.coord.lat,
                temp = cityWeatherRetrofit.main.temp,
                feelsLike = cityWeatherRetrofit.main.feels_like,
                pressure = cityWeatherRetrofit.main.pressure,
                humidity = cityWeatherRetrofit.main.humidity,
                windSpeed = cityWeatherRetrofit.wind.speed,
                windDirection = cityWeatherRetrofit.wind.deg,
                clouds = cityWeatherRetrofit.clouds.all
        )
    }

    fun cityWeatherToCityTableEntity(cityWeather: CityWeather)
            = CityTableEntity(
            cityName = cityWeather.cityName,
            lat = cityWeather.lat,
            lon = cityWeather.lon
    )
}