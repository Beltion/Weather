package com.example.weather.data.mappers

import android.util.Log
import com.example.core.business.entities.CityWeather
import com.example.weather.data.entities.DayOfWeek
import com.example.weather.data.entities.ThreeHourAtDay
import com.example.weather.data.entities.json.CityWeatherRetrofit
import com.example.weather.data.entities.json.WeekCityWeatherRetrofit
import com.example.weather.frameworks.room.table.CityTableEntity


object WeatherMapper {
    fun cityWeatherRetrofitToCityWeather(cityWeatherRetrofit: CityWeatherRetrofit): CityWeather
            = CityWeather(
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

    fun cityWeatherToCityTableEntity(cityWeather: CityWeather)
            = CityTableEntity(
            cityName = cityWeather.cityName
    )

    fun cityWeekRetrofitToDayOfWeek(weekCityWeatherRetrofit: WeekCityWeatherRetrofit): ArrayList<DayOfWeek>{

        val days = ArrayList<DayOfWeek>()
        val atThreeHourList = ArrayList<ThreeHourAtDay>()

        var currentDayDate: Int = weekCityWeatherRetrofit.list[0].dt_txt.substring(8,10).toInt()
        var currentMonthDate: Int = weekCityWeatherRetrofit.list[0].dt_txt.substring(5,7).toInt()
        var currentTimeDate: String = weekCityWeatherRetrofit.list[0].dt_txt.substring(11,16)

        val size = weekCityWeatherRetrofit.list.size
        weekCityWeatherRetrofit.list[0].let {item ->
            val threeHourAtDay = ThreeHourAtDay(
                    time = currentTimeDate,
                    main = item.main,
                    weather = item.weather,
                    clouds = item.clouds,
                    wind = item.wind,
                    rain = item.rain,
                    snow = item.snow,
                    visibility = item.visibility
            )
            atThreeHourList.add(threeHourAtDay)
            Log.d("MAPPER", "Three ThreeHourAtDay")
            Log.d("MAPPER", "$currentDayDate.$currentMonthDate $currentTimeDate")
            Log.d("MAPPER", "First: $threeHourAtDay")
        }

        weekCityWeatherRetrofit.list.let { weatherList ->
            for (i in 1 until size){
                if (weatherList[i].dt_txt.substring(8,10).toInt() == currentDayDate){
                    currentTimeDate = weekCityWeatherRetrofit.list[i].dt_txt.substring(11,16)
                    weatherList[i].let {item ->
                        val threeHourAtDay = ThreeHourAtDay(
                                time = currentTimeDate,
                                main = item.main,
                                weather = item.weather,
                                clouds = item.clouds,
                                wind = item.wind,
                                rain = item.rain,
                                snow = item.snow,
                                visibility = item.visibility
                        )
                        Log.d("MAPPER", "Next ThreeHourAtDay")
                        Log.d("MAPPER", "$currentDayDate.$currentMonthDate $currentTimeDate")
                        Log.d("MAPPER", "Next: $threeHourAtDay")
                        atThreeHourList.add(threeHourAtDay)
                    }
                } else {
                    val dayOfWeek = DayOfWeek(
                            dateDay =  currentDayDate,
                            dateMonth =  currentMonthDate,
                            weatherThreeHourEaches = atThreeHourList
                            )
                    days.add(dayOfWeek)
                    Log.d("MAPPER", "atThreeHourList:${atThreeHourList.size}")
                    atThreeHourList.clear()
                    currentMonthDate = weatherList[i].dt_txt.substring(5,7).toInt()
                    currentDayDate = weatherList[i].dt_txt.substring(8,10).toInt()
                }
            }
        }
        Log.d("MAPPER", "atThreeHourList:${atThreeHourList.size}")
        val dayOfWeek = DayOfWeek(
                dateDay =  currentDayDate,
                dateMonth =  currentMonthDate,
                weatherThreeHourEaches = atThreeHourList
        )

        Log.d("MAPPER", "Next ThreeHourAtDay")
        Log.d("MAPPER", "$currentDayDate.$currentMonthDate $currentTimeDate")
        Log.d("MAPPER", "Next: $dayOfWeek")
        days.add(dayOfWeek)

        Log.d("MAPPER", "Days count: ${days.size}")
        for(day in days){
            Log.d("MAPPER", "day:${day.weatherThreeHourEaches.size}")
        }
        return days
    }
}