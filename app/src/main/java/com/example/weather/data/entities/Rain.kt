package com.example.weather.data.entities


import com.google.gson.annotations.SerializedName

//  The CityWeatherChildEntities class
//  Should be in core but because of SerializedName can't be there
data class Rain(
        @SerializedName("1h")
        val atHour: Float
)