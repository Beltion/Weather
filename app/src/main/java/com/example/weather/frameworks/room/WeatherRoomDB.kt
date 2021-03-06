package com.example.weather.frameworks.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.weather.frameworks.room.table.CityTableEntity

@Database(entities = [CityTableEntity::class], version = 1, exportSchema = false)
abstract class WeatherRoomDB : RoomDatabase(){

    abstract fun cityWeatherDAO() : CityWeatherDAO

    companion object{
        @Volatile
        private var INSTANCE: WeatherRoomDB? = null

        fun getDatabase(context: Context): WeatherRoomDB {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WeatherRoomDB::class.java,
                    "city_weather_db"
                ).build()
                INSTANCE = instance

                instance
            }
        }
    }
}