package com.example.weather.presentation.city_list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.weather.business.CityListView

class CityListActivity :
        AppCompatActivity(),
        CityListView
{

    override fun onStart() {
        super.onStart()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initRV() {
        TODO("Not yet implemented")
    }

    override fun getCityName(): String {
        TODO("Not yet implemented")
    }

    override fun getStringFromID(stringID: Int): String {
        TODO("Not yet implemented")
    }

    override fun showToast(str: String) {
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