package com.example.weather.presentation.city_list

import android.util.Log
import com.example.core.business.callbacks.FailureCallback
import com.example.core.business.callbacks.SuccessCallback
import com.example.core.business.entities.CityWeather
import com.example.weather.business.CityListPresenter
import com.example.weather.business.CityListView
import com.example.weather.frameworks.room.table.CityTableEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.lang.ref.WeakReference

class CityListPresenterImpl : CityListPresenter {

    private val TAG = CityListPresenterImpl::class.simpleName
    private var view: WeakReference<CityListView>? = null
    private val model = CityListModel()

    override fun initView(v: CityListView) {
        view = WeakReference(v)
    }

    override fun onItemClick(cityWeather: CityWeather) {
        Log.d(TAG, "click on -> ${cityWeather.cityName}")
        view?.get()?.startForecastActivity()
    }

    override fun onItemLongClick(cityWeather: CityWeather) {
        Log.d(TAG, "long click on -> ${cityWeather.cityName}")
    }

    override fun onViewCreated() {
        view?.get()?.let{view ->
            val roomDS = view.getDataBaseDAO()
            model.getAllCityWeather(roomDS, object : SuccessCallback{
                override fun onSuccess(data: Any?) {
                    if (data is ArrayList<*>){
                        Log.d(TAG, "City size: ${data.size}")
                        for (city in data as ArrayList<CityTableEntity>){
                            Log.d(TAG, "City: ${city.cityName}")
                        }
                            if(data.size > 0 ){
                                Log.d(TAG, "City size before call getAllCitiesTodayWeather: ${data.size}")
                                val weathers = ArrayList<CityWeather>()
                                GlobalScope.launch(Dispatchers.Main) {
                                    weathers.addAll(
                                             async {
                                                 model.getAllCitiesTodayWeather(data)
                                             }.await()
                                    )
                                    Log.d(TAG, "City size: ${weathers.size}")
                                    view.initRV(weathers)
                                    view.showContent()
                                }

                            } else {
                                view.startFirstCityActivity()
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