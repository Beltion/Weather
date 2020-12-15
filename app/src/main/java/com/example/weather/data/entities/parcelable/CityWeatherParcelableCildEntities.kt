package com.example.weather.data.entities.parcelable

import android.os.Parcel
import android.os.Parcelable

data class CloudsParcelable(
        val all: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(all)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CloudsParcelable> {
        override fun createFromParcel(parcel: Parcel): CloudsParcelable {
            return CloudsParcelable(parcel)
        }

        override fun newArray(size: Int): Array<CloudsParcelable?> {
            return arrayOfNulls(size)
        }
    }
}

data class CoordinateParcelable(
        val lon: String?,
        val lat: String?
): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(lon)
        parcel.writeString(lat)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CoordinateParcelable> {
        override fun createFromParcel(parcel: Parcel): CoordinateParcelable {
            return CoordinateParcelable(parcel)
        }

        override fun newArray(size: Int): Array<CoordinateParcelable?> {
            return arrayOfNulls(size)
        }
    }
}


data class MainWeatherDataParcelable(
        val temp: Float,
        val feels_like: Float,
        val temp_min: Float,
        val temp_max: Float,
        val pressure: Float,
        val humidity: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readFloat(),
            parcel.readFloat(),
            parcel.readFloat(),
            parcel.readFloat(),
            parcel.readFloat(),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeFloat(temp)
        parcel.writeFloat(feels_like)
        parcel.writeFloat(temp_min)
        parcel.writeFloat(temp_max)
        parcel.writeFloat(pressure)
        parcel.writeInt(humidity)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainWeatherDataParcelable> {
        override fun createFromParcel(parcel: Parcel): MainWeatherDataParcelable {
            return MainWeatherDataParcelable(parcel)
        }

        override fun newArray(size: Int): Array<MainWeatherDataParcelable?> {
            return arrayOfNulls(size)
        }
    }
}

data class SystemCityDataParcelable(
        val type: Int,
        val id: Int,
        val country: String?,
        val sunrise: Int,
        val sunset: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(type)
        parcel.writeInt(id)
        parcel.writeString(country)
        parcel.writeInt(sunrise)
        parcel.writeInt(sunset)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SystemCityDataParcelable> {
        override fun createFromParcel(parcel: Parcel): SystemCityDataParcelable {
            return SystemCityDataParcelable(parcel)
        }

        override fun newArray(size: Int): Array<SystemCityDataParcelable?> {
            return arrayOfNulls(size)
        }
    }
}

data class SnowParcelable(
        val atHour: Float
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readFloat()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeFloat(atHour)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SnowParcelable> {
        override fun createFromParcel(parcel: Parcel): SnowParcelable {
            return SnowParcelable(parcel)
        }

        override fun newArray(size: Int): Array<SnowParcelable?> {
            return arrayOfNulls(size)
        }
    }
}

data class WeatherParcelable(
        val id: Int,
        val main: String?,
        val description: String?,
        val icon: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(main)
        parcel.writeString(description)
        parcel.writeString(icon)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<WeatherParcelable> {
        override fun createFromParcel(parcel: Parcel): WeatherParcelable {
            return WeatherParcelable(parcel)
        }

        override fun newArray(size: Int): Array<WeatherParcelable?> {
            return arrayOfNulls(size)
        }
    }
}

data class WindParcelable(
        val speed: Int,
        val deg: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(speed)
        parcel.writeInt(deg)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<WindParcelable> {
        override fun createFromParcel(parcel: Parcel): WindParcelable {
            return WindParcelable(parcel)
        }

        override fun newArray(size: Int): Array<WindParcelable?> {
            return arrayOfNulls(size)
        }
    }
}