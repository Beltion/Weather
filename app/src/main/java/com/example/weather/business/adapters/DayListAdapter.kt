package com.example.weather.business.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.R

class DayListAdapter(
        private val days: ArrayList<Int>,
        private val listener: OnDayListClickListener
) : RecyclerView.Adapter<DayListAdapter.DayVH>() {

    class DayVH(item: View) : RecyclerView.ViewHolder(item){
        val name = item.findViewById<TextView>(R.id.week_day_item)

        fun onClick(day: Int, listener: OnDayListClickListener){
            itemView.setOnClickListener {
                listener.onDayClick(day)
            }
        }
    }

    interface OnDayListClickListener{
        fun onDayClick(day: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayVH {
        val ctx = parent.context
        val inflater = LayoutInflater.from(ctx)
        val dayCard = inflater.inflate(R.layout.week_day_item, parent, false)
        return DayVH(dayCard)
    }

    override fun getItemCount()
            = days.size

    override fun onBindViewHolder(holder: DayVH, position: Int) {
        holder.name.text = days[position].toString()

        holder.onClick(
                days[position],
                listener
        )
    }
}