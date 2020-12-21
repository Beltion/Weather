package com.example.weather.presentation.city_list

import android.nfc.Tag
import android.util.Log
import com.example.core.business.callbacks.FailureCallback
import com.example.core.business.callbacks.SuccessCallback
import com.example.weather.business.CityListPresenter
import com.example.weather.business.CityListView
import com.example.weather.data.mappers.WeatherMapper
import java.lang.ref.WeakReference

class CityListPresenterImpl : CityListPresenter {

    private val TAG = CityListPresenterImpl::class.simpleName
    private var view: WeakReference<CityListView>? = null
    private val model = CityListModel()

    override fun initView(v: CityListView) {
        view = WeakReference(v)
    }

    override fun onItemClick(cityTitle: String) {
        TODO("Not yet implemented")
    }

    override fun onItemLongClick() {
        TODO("Not yet implemented")
    }

    override fun onViewCreated() {
        view?.get()?.let{view ->
            val roomDS = view.getDataBaseDAO()
            model.getAllCityWeather(roomDS, object : SuccessCallback{
                override fun onSuccess(data: Any?) {
                    if (data is ArrayList<*>){
                        Log.d(TAG, "City size: ${data.size}")
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