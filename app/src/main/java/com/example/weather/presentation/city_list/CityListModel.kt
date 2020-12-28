 package com.example.weather.presentation.city_list

import android.util.Log
import com.example.core.business.callbacks.FailureCallback
import com.example.core.business.callbacks.SuccessCallback
import com.example.core.business.entities.CityWeather
import com.example.core.use_case.all_city.GetAllCityWeatherToday
import com.example.core.use_case.all_city.InsertToAllCityWeather
import com.example.core.use_case.city.GetCityWeatherToday
import com.example.weather.data.entities.json.CityWeatherRetrofit
import com.example.weather.data.mappers.WeatherMapper
import com.example.weather.data.repositories.AllCityWeatherRepositoryRoom
import com.example.weather.data.repositories.CityWeatherRepositoryApi
import com.example.weather.frameworks.CityWeatherApiDS
import com.example.weather.frameworks.Common
import com.example.weather.frameworks.room.CityWeatherDAO
import com.example.weather.frameworks.room.table.CityTableEntity
import kotlinx.coroutines.*
import retrofit2.Response
import retrofit2.awaitResponse

 class CityListModel {
    private val job = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.IO + job)
    private val TAG = CityListModel::class.simpleName

    fun getAllCityWeather(roomDS: CityWeatherDAO,
                          successCallback: SuccessCallback,
                          failureCallback: FailureCallback) = scope.launch {
        val getAllCityWeatherToday = GetAllCityWeatherToday(AllCityWeatherRepositoryRoom(roomDS))

        getAllCityWeatherToday.getCitiesWeatherToday(
                object : SuccessCallback {
                    override fun onSuccess(data: Any?) {
                        successCallback.onSuccess(data)
                    }

                },
                object : FailureCallback {
                    override fun onFailure(tag: String, error: Any?) {
                        failureCallback.onFailure(tag, error)
                    }

                }
        )
    }

    fun insertCityWeather(roomDS: CityWeatherDAO,
                          cityWeather: CityWeather,
                          successCallback: SuccessCallback,
                          failureCallback: FailureCallback) = scope.launch {
        val insertToAllCityWeather = InsertToAllCityWeather(AllCityWeatherRepositoryRoom(roomDS))

        insertToAllCityWeather.insert(
                cityWeather,
                object : SuccessCallback {
                    override fun onSuccess(data: Any?) {
                        successCallback.onSuccess(data)
                    }
                }, object : FailureCallback {
            override fun onFailure(tag: String, error: Any?) {
                failureCallback.onFailure(tag, error)
            }

        }
        )
    }
    /*
    *   It works but it's not Clean Architecture way
    */
     suspend fun getAllCitiesTodayWeather(cities: ArrayList<CityTableEntity>): ArrayList<CityWeather> {
        val citiesWeather = ArrayList<CityWeather>()
        GlobalScope.async(scope.coroutineContext) {
            for(city in cities){
                var cityWeather: CityWeather? = null
                Log.d(TAG, "Before get ${city.cityName}")
                val response: Response<CityWeatherRetrofit> = async {
                    Common.retrofitService.getOneDayWeatherCo(city.cityName)
                }.await()
                if(response.isSuccessful && response.body() != null){
                    Log.d(TAG, "Response: ${response.body()}")
                    cityWeather = WeatherMapper.cityWeatherRetrofitToCityWeather(response.body()!!)
                }
                cityWeather?.let {
                    citiesWeather.add(it)
                } ?: Log.d(TAG, "return $citiesWeather")


            }
        }.await()
/*
*   The cobe below must works in Clean Architecture but it is not
*   I think couse in UseCase(core) I can't call GlobalScope and call async{}.await()
*/
//            GlobalScope.async(scope.coroutineContext) {
//            Log.d(TAG, "before getCityWeatherToday")
//             val getCityWeatherToday = GetCityWeatherToday(CityWeatherRepositoryApi())
//             for(city in cities){
//                     val cityWeatherToday = async { getCityWeatherToday.getWeatherToday(city.cityName)}.await()
//                 if (cityWeatherToday is CityWeather){
//                     citiesWeather.add(cityWeatherToday)
//                 }
//             }
//            Log.d(TAG, "after getCityWeatherToday")
//        }.await()
         Log.d(TAG, "return $citiesWeather")
         return citiesWeather
    }

     suspend fun getCityTodayWeather(city: String): CityWeather? {
         var cityWeather: CityWeather? = null
         GlobalScope.async(scope.coroutineContext) {
             val response: Response<CityWeatherRetrofit> = async {
                 Common.retrofitService.getOneDayWeatherCo(city)
             }.await()
             if(response.isSuccessful && response.body() != null){
                 Log.d(TAG, "Response: ${response.body()}")
                 cityWeather = WeatherMapper.cityWeatherRetrofitToCityWeather(response.body()!!)
             }
         }
         return cityWeather
     }
}