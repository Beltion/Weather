package com.example.weather.data.entities

import android.os.Parcel
import android.os.Parcelable
import com.example.core.business.entities.*
import com.example.weather.data.entities.parcelable.*
import java.util.HashMap

data class CityWeatherParcelable(
        val cod: Int,
        val base: String?,
        val visibility: String?,
        val dt: Int,
        val timezone: Int,
        val id: Int,
        val name: String?,
        val coord: CoordinateParcelable?, //  latitude and longitude of the city
        val weather: ArrayList<WeatherParcelable>, //    More info Weather condition codes
        val main: MainWeatherDataParcelable?,
        val wind: WindParcelable?,
        val snow: SnowParcelable?, //   <- have SerializedName annotation
        val clouds: CloudsParcelable?,
        val sys: SystemCityDataParcelable?
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readParcelable<CoordinateParcelable>(CoordinateParcelable::class.java.classLoader),
            arrayListOf<WeatherParcelable>().apply {
                parcel.readArrayList(WeatherParcelable::class.java.classLoader)
            },
            parcel.readParcelable<MainWeatherDataParcelable>(MainWeatherDataParcelable::class.java.classLoader),
            parcel.readParcelable<WindParcelable>(WindParcelable::class.java.classLoader),
            parcel.readParcelable<SnowParcelable>(SnowParcelable::class.java.classLoader),
            parcel.readParcelable<CloudsParcelable>(CloudsParcelable::class.java.classLoader),
            parcel.readParcelable<SystemCityDataParcelable>(SystemCityDataParcelable::class.java.classLoader)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(cod)
        parcel.writeString(base)
        parcel.writeString(visibility)
        parcel.writeInt(dt)
        parcel.writeInt(timezone)
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeParcelable(coord, flags)
        parcel.writeList(weather)
        parcel.writeParcelable(main, flags)
        parcel.writeParcelable(wind, flags)
        parcel.writeParcelable(snow, flags)
        parcel.writeParcelable(clouds, flags)
        parcel.writeParcelable(sys, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CityWeatherParcelable> {
        override fun createFromParcel(parcel: Parcel): CityWeatherParcelable {
            return CityWeatherParcelable(parcel)
        }

        override fun newArray(size: Int): Array<CityWeatherParcelable?> {
            return arrayOfNulls(size)
        }
    }
}