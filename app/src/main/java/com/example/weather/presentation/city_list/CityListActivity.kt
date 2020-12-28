package com.example.weather.presentation.city_list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.core.business.entities.CityWeather
import com.example.weather.R
import com.example.weather.business.CityListView
import com.example.weather.business.adapters.CityListAdapter
import com.example.weather.data.entities.parcelable.CityParcelable
import com.example.weather.frameworks.room.CityWeatherDAO
import com.example.weather.frameworks.room.WeatherRoomDB
import com.example.weather.presentation.first_city.FirstCityActivity
import com.example.weather.presentation.week_city.WeekCityWeatherActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class CityListActivity :
        AppCompatActivity(),
        CityListView,
        CityListAdapter.OnCityListClickListener
{

    private lateinit var rv: RecyclerView
    private lateinit var container: ConstraintLayout
    private lateinit var progress: ProgressBar
    private lateinit var fab: FloatingActionButton

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

    override fun initRV(citiesWeather: ArrayList<CityWeather>) {
        rv.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
        val adapter = CityListAdapter(citiesWeather, this)
        rv.adapter = adapter
    }

    override fun getStringFromID(stringID: Int): String
        = getString(stringID)

    override fun showToast(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
    }

    override fun startForecastActivity() {
        val intent = Intent(this, WeekCityWeatherActivity::class.java)
        startActivity(intent)
    }

    override fun startFirstCityActivity() {
        val intent = Intent(this, FirstCityActivity::class.java)
        startActivity(intent)
    }

    override fun getDataBaseDAO(): CityWeatherDAO
        = WeatherRoomDB.getDatabase(this).cityWeatherDAO()


    override fun initViewItems() {
        progress = findViewById(R.id.progressbar)
        container = findViewById(R.id.content_city_list)

        rv = findViewById(R.id.rv_cities_city_list)
        rv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        fab = findViewById(R.id.add_fab_city_list)
    }

    override fun initLogicItems() {
        presenter.initView(this)
        presenter.onViewCreated()

        fab.setOnClickListener {
            startFirstCityActivity()
        }
    }

    override fun showContent() {
        container.visibility = View.VISIBLE
        progress.visibility = View.INVISIBLE
    }

    override fun hideContent() {
        container.visibility = View.INVISIBLE
        progress.visibility = View.VISIBLE
    }

    override fun onClick(cityWeather: CityWeather) {
        presenter.onItemClick(cityWeather)
    }

    override fun onLongClick(cityWeather: CityWeather) {
        presenter.onItemLongClick(cityWeather)
    }
}