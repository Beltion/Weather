package com.example.weather.presentation.city_list

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.R
import com.example.weather.business.CityListView
import com.example.weather.data.entities.json.CityWeatherRetrofit
import com.example.weather.data.entities.parcelable.CityParcelable
import com.example.weather.frameworks.room.CityWeatherDAO
import com.example.weather.frameworks.room.WeatherRoomDB
import com.example.weather.presentation.first_city.FirstCityActivity

class CityListActivity :
        AppCompatActivity(),
        CityListView
{

    private lateinit var rv: RecyclerView
    private lateinit var container: ConstraintLayout
    private lateinit var progress: ProgressBar

    private var presenter = CityListPresenterImpl()

    override fun onStart() {
        super.onStart()
        initLogicItems()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.city_list)
        initViewItems()
    }

    override fun initRV(citiesWeatherRetrofit: ArrayList<CityWeatherRetrofit>?) {
        TODO("Not yet implemented")
    }

    override fun getStringFromID(stringID: Int): String
        = getString(stringID)

    override fun showToast(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
    }

    override fun startForecastActivity(coordinate: CityParcelable) {
        val intent = Intent(this, CityListActivity::class.java)
        intent.putExtra("coord", coordinate)
        startActivity(intent)
    }

    override fun startFirstCityActivity() {
        val intent = Intent(this, FirstCityActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun getDataBaseDAO(): CityWeatherDAO
        = WeatherRoomDB.getDatabase(this).cityWeatherDAO()


    override fun initViewItems() {
        progress = findViewById(R.id.progressbar)
        container = findViewById(R.id.content_city_list)

        rv = findViewById(R.id.rv_cities_city_list)
        rv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }

    override fun initLogicItems() {
        presenter.initView(this)
        presenter.onViewCreated()
    }

    override fun showContent() {
        container.visibility = View.VISIBLE
        progress.visibility = View.INVISIBLE
    }

    override fun hideContent() {
        container.visibility = View.INVISIBLE
        progress.visibility = View.VISIBLE
    }
}