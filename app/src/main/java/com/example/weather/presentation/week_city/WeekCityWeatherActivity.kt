package com.example.weather.presentation.week_city

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.weather.business.WeekCityView
import com.example.weather.data.entities.json.WeekCityWeatherRetrofit

class WeekCityWeatherActivity :
        AppCompatActivity(),
        WeekCityView {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getStringFromID(stringID: Int): String {
        TODO("Not yet implemented")
    }

    override fun showToast(str: String) {
        TODO("Not yet implemented")
    }

    override fun initRV(weekCityWeatherRetrofit: WeekCityWeatherRetrofit) {
        TODO("Not yet implemented")
    }

    override fun initViewItems() {
        TODO("Not yet implemented")
    }

    override fun initLogicItems() {
        TODO("Not yet implemented")
    }

    override fun showContent() {
        TODO("Not yet implemented")
    }

    override fun hideContent() {
        TODO("Not yet implemented")
    }
}