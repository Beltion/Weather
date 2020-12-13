package com.example.weather.presentation.first_city

import android.util.Log
import com.example.weather.business.FirstCityPresenter
import com.example.weather.business.FirstCityView
import java.lang.ref.WeakReference

class FirstCityPresenterImpl : FirstCityPresenter {

    private val TAG = FirstCityPresenterImpl::class.simpleName
    private var view: WeakReference<FirstCityView>? = null
    private val model = FirstCityModel()

    override fun initView(v: FirstCityView) {
        view = WeakReference(v)
    }

    override fun onBtnClick(cityTitle: String) {
        if (cityTitle.isNotBlank() || cityTitle.isNotEmpty()){
            Log.d(TAG, "btnClick city title -> $cityTitle")
        }

    }

    override fun onViewCreated() {
        view?.get()?.showContent()

    }
}