package com.example.weather.data.entities.json

import com.google.gson.annotations.SerializedName

//  The CityWeatherChildEntities class
//  Should be in core but because of SerializedName can't be there
data class Snow(
    @SerializedName("1h")
    val atHour: Float
)