package com.example.weather.presentation.first_city

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.weather.R
import com.example.weather.business.FirstCityView

class FirstCityActivity :
    AppCompatActivity(),
    FirstCityView
{

    private lateinit var cityEt: EditText
    private lateinit var cityBtn: Button
    private lateinit var container: ConstraintLayout
    private lateinit var progress: ProgressBar

    private val presenter = FirstCityPresenterImpl()

    override fun onStart() {
        super.onStart()
        initLogicItems()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_city)

        initViewItems()
    }

    override fun getCityName(): String =
            cityEt.text.toString()

    override fun getStringFromID(stringID: Int): String =
            getString(stringID)

    override fun initViewItems() {
        progress = findViewById(R.id.progressbar)
        container = findViewById(R.id.content_first_city)

        cityEt = findViewById(R.id.city_et_first_city)
        cityBtn = findViewById(R.id.get_city_btn_first_city)

    }

    override fun initLogicItems() {
        presenter.initView(this)
        cityBtn.setOnClickListener {
            presenter.onBtnClick(
                    cityEt.text.toString()
            )
        }

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