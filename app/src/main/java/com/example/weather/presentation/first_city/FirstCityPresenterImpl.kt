package com.example.weather.presentation.first_city

import android.util.Log
import com.example.core.business.callbacks.FailureCallback
import com.example.core.business.callbacks.SuccessCallback
import com.example.weather.data.entities.json.CityWeatherRetrofit
import com.example.weather.business.FirstCityPresenter
import com.example.weather.business.FirstCityView
import com.example.weather.data.mappers.WeatherMapper
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
            view?.get()?.let{view ->
                model.getWeather(cityTitle,object : SuccessCallback{
                    override fun onSuccess(data: Any?) {
                        if (data is CityWeatherRetrofit){
                            Log.d(TAG, data.toString())
                            try {
                                view.startNewActivity(
                                        WeatherMapper().cityWeatherToParcelable(data)
                                )
                            } catch (e: Exception) {
                                e.printStackTrace()
                                Log.e(TAG, "to Parcelable error -> ${e.message}")
                            }

                        } else {
                            Log.e(TAG, data.toString())
                        }
                    }
                },  object : FailureCallback{
                    override fun onFailure(tag: String, error: Any?) {
                        Log.d("$TAG -> $tag", error.toString())
                    }

                })

            }

        }

    }

    override fun onViewCreated() {
        view?.get()?.showContent()

    }
}