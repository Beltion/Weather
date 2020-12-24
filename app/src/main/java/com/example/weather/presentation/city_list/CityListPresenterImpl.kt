package com.example.weather.presentation.city_list

import android.util.Log
import com.example.core.business.callbacks.FailureCallback
import com.example.core.business.callbacks.SuccessCallback
import com.example.core.business.entities.CityWeather
import com.example.weather.business.CityListPresenter
import com.example.weather.business.CityListView
import com.example.weather.frameworks.room.table.CityTableEntity
import java.lang.ref.WeakReference

class CityListPresenterImpl : CityListPresenter {

    private val TAG = CityListPresenterImpl::class.simpleName
    private var view: WeakReference<CityListView>? = null
    private val model = CityListModel()

    override fun initView(v: CityListView) {
        view = WeakReference(v)
    }

    override fun onItemClick(cityTitle: CityWeather) {
        TODO("Not yet implemented")
    }

    override fun onItemLongClick(cityWeather: CityWeather) {
        TODO("Not yet implemented")
    }

    override fun onViewCreated() {
        view?.get()?.let{view ->
            val roomDS = view.getDataBaseDAO()
            model.getAllCityWeather(roomDS, object : SuccessCallback{
                override fun onSuccess(data: Any?) {
                    if (data is ArrayList<*>){
                        Log.d(TAG, "City size: ${data.size}")
                        if(data.size > 0 ){
                            (data as ArrayList<CityTableEntity>).forEach {
                                Log.d(TAG, "City name: ${it.cityName}")
                            }
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