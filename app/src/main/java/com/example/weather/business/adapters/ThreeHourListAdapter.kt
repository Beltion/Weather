package com.example.weather.business.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.R
import com.example.weather.data.entities.ThreeHourAtDay
import com.squareup.picasso.Picasso

class ThreeHourListAdapter(
   private val dayAtHours: ArrayList<ThreeHourAtDay>
) : RecyclerView.Adapter<ThreeHourListAdapter.ThreeHourVH>() {
    class ThreeHourVH(item: View) : RecyclerView.ViewHolder(item) {
        val img = item.findViewById<ImageView>(R.id.img_3hour)
        val time = item.findViewById<TextView>(R.id.time_3hour)
        val desc = item.findViewById<TextView>(R.id.desc_3hour)
        val temp = item.findViewById<TextView>(R.id.temp_3hour)
        val pressure = item.findViewById<TextView>(R.id.pressure_3hour)
        val humidity = item.findViewById<TextView>(R.id.humidity_3hour)
        val clouds = item.findViewById<TextView>(R.id.clouds_3hour)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThreeHourVH {
        val ctx = parent.context
        val inflater = LayoutInflater.from(ctx)
        val dayAtHourCard = inflater.inflate(R.layout.week_day_3hour_tem, parent, false)
        return ThreeHourVH(dayAtHourCard)
    }

    override fun getItemCount()
            = dayAtHours.size

    override fun onBindViewHolder(holder: ThreeHourVH, position: Int) {
        holder.time.text = dayAtHours[position].time
        holder.desc.text = dayAtHours[position].weather[0].description
        val temp: Int = dayAtHours[position].main.temp.toInt() - 273
        holder.temp.text = "температура $temp \u2103"
        holder.pressure.text = "двление ${dayAtHours[position].main.pressure}"
        holder.humidity.text = "влажность ${dayAtHours[position].main.humidity} %"
        holder.clouds.text = "облачность ${dayAtHours[position].clouds.all} %"

        Picasso.get()
                .load("http://openweathermap.org/img/wn/${dayAtHours[position].weather[0].icon}@2x.png")
                .fit()
                .into(holder.img)
    }

}