package com.example.weather.presentation.first_city

import android.util.Log
import com.example.core.business.callbacks.FailureCallback
import com.example.core.business.callbacks.SuccessCallback
import com.example.core.business.entities.CityWeather
import com.example.weather.business.FirstCityPresenter
import com.example.weather.business.FirstCityView
import com.example.weather.frameworks.room.table.CityTableEntity
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
                        if (data is CityWeather){
                            Log.d(TAG, data.toString())
                            try {
                                model.insertCityWeather(
                                        view.getDataBaseDAO(),
                                        data,
                                        object : SuccessCallback{
                                            override fun onSuccess(data: Any?) {
                                                Log.d(TAG, data.toString())
                                            }

                                        },
                                        object : FailureCallback{
                                            override fun onFailure(tag: String, error: Any?) {
                                                Log.e(tag, error.toString())
                                            }

                                        }
                                )
                                view.startNewActivity()
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
        view?.get()?.let{ view ->
            val roomDS = view.getDataBaseDAO()
            model.getAllCityWeather(roomDS, object : SuccessCallback{
                override fun onSuccess(data: Any?) {
                    if (data is ArrayList<*>){
                        Log.d(TAG, "City size: ${data.size}")
                        for (city in data as ArrayList<CityTableEntity>){
                            Log.d(TAG, "City: ${city.cityName}")
                        }
                        if(data.size > 0 ){
                            Log.d(TAG, "Show cancel btn")
                            view.showCancelBtn()
                            view.showContent()
                        } else {
                            view.showContent()
                        }
                    }
                }
            },  object : FailureCallback{
                override fun onFailure(tag: String, error: Any?) {
                    TODO("Not yet implemented")
                }

            }
            )

        }

    }
}