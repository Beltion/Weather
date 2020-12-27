package com.example.weather.data.entities

//  This is data of one day at week

data class DayOfWeek(
        val dateDay: Int,
        val dateMonth: Int,
        val weatherThreeHourEaches: ArrayList<ThreeHourAtDay>
)