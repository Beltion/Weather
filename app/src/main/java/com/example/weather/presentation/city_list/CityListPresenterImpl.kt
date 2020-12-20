package com.example.weather.presentation.city_list

import com.example.weather.business.CityListPresenter
import com.example.weather.business.CityListView
import java.lang.ref.WeakReference

class CityListPresenterImpl : CityListPresenter {

    private var view: WeakReference<CityListView>? = null

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
            view.showContent()
        }
    }
}