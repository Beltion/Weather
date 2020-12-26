package com.example.weather.business.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.core.business.entities.CityWeather
import com.example.weather.R

class CityListAdapter(
        private val cityWeatherList: ArrayList<CityWeather>,
        private val clickListener: OnCityListClickListener
) : RecyclerView.Adapter<CityListAdapter.CityWeatherVH>() {

    class CityWeatherVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.name_city_list_item)
        val main = itemView.findViewById<TextView>(R.id.main_city_list_item)
        val desc = itemView.findViewById<TextView>(R.id.desc_city_list_item)
//        val icon = itemView.findViewById<TextView>(R.id.icon_city_list_item)
        val temp = itemView.findViewById<TextView>(R.id.temp_city_list_item)
        val feelsLike = itemView.findViewById<TextView>(R.id.feels_like_city_list_item)
        val pressure = itemView.findViewById<TextView>(R.id.pressure_city_list_item)
        val humidity = itemView.findViewById<TextView>(R.id.humidity_city_list_item)
        val windSpeed = itemView.findViewById<TextView>(R.id.wind_speed_city_list_item)
        val windDirection = itemView.findViewById<TextView>(R.id.wind_direction_city_list_item)
        val clouds = itemView.findViewById<TextView>(R.id.clouds_city_list_item)

        fun onClick(cW: CityWeather, listener: OnCityListClickListener){
            itemView.setOnClickListener{
                listener.onClick(cW)
            }
        }

        fun onLongClick(cW: CityWeather, listener: OnCityListClickListener){
            itemView.setOnLongClickListener{
                listener.onLongClick(cW)
                true
            }
        }
    }

    interface OnCityListClickListener {
        fun onClick(cityWeather: CityWeather)
        fun onLongClick(cityWeather: CityWeather)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityWeatherVH {
        val ctx = parent.context
        val inflater = LayoutInflater.from(ctx)
        val cityWeatherCard = inflater.inflate(R.layout.city_list_item, parent, false)
        return CityWeatherVH(cityWeatherCard)
    }

    override fun getItemCount()
            = cityWeatherList.size

    override fun onBindViewHolder(holder: CityWeatherVH, position: Int) {
        cityWeatherList[position].let{cityWeather ->
            holder.name.text = cityWeather.cityName
            holder.main.text = cityWeather.main
            holder.desc.text = cityWeather.desc
            holder.temp.text = cityWeather.temp.toString()
            holder.feelsLike.text = cityWeather.feelsLike.toString()
            holder.pressure.text = cityWeather.pressure.toString()
            holder.humidity.text = cityWeather.humidity.toString()
            holder.windSpeed.text = cityWeather.windSpeed.toString()
            holder.windDirection.text = cityWeather.windDirection.toString()
            holder.clouds.text = cityWeather.clouds.toString()
        }

    }

}