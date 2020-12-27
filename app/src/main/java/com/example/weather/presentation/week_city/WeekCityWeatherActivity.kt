package com.example.weather.presentation.week_city

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.R
import com.example.weather.business.WeekCityView
import com.example.weather.business.adapters.DayListAdapter
import com.example.weather.data.entities.ThreeHourAtDay

class WeekCityWeatherActivity :
        AppCompatActivity(),
        WeekCityView,
        DayListAdapter.OnDayListClickListener{

    lateinit var rvDays: RecyclerView
    lateinit var rvDayAtHours: RecyclerView
    lateinit var container: ConstraintLayout
    lateinit var progressBar: ProgressBar
    lateinit var cityName: TextView

    lateinit var presenter: WeekCityWeatherPresenter

    override fun onStart() {
        super.onStart()
        initLogicItems()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.week_list)
        initViewItems()
    }

    override fun getStringFromID(stringID: Int): String {
        TODO("Not yet implemented")
    }

    override fun showToast(str: String) {
        TODO("Not yet implemented")
    }

    override fun initDaysRV(days: ArrayList<Int>) {
        rvDays.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.HORIZONTAL, false)
        rvDays.adapter = DayListAdapter(days, this)
    }

    override fun initDayHoursRV(daysAtHours: ArrayList<ThreeHourAtDay>) {
        rvDayAtHours.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
    }

    override fun setCityName(name: String) {
        cityName.text = name
    }

    override fun initViewItems() {
        container = findViewById(R.id.content_week_list)
        progressBar = findViewById(R.id.progressbar)

        rvDays = findViewById(R.id.days_list_week_list)
        rvDayAtHours = findViewById(R.id.day_hours_list_week_list)
        cityName = findViewById(R.id.city_name_week_list)
    }

    override fun initLogicItems() {
        presenter = WeekCityWeatherPresenter()
        presenter.initView(this)
        presenter.onViewCreated()
    }

    override fun showContent() {
        container.visibility = View.VISIBLE
        progressBar.visibility = View.INVISIBLE
    }

    override fun hideContent() {
        container.visibility = View.INVISIBLE
        progressBar.visibility = View.VISIBLE

    }

    override fun onDayClick(day: Int) {
        presenter.onDayClick(day)
    }
}