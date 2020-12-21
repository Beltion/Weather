package com.example.weather.data.entities.parcelable

import android.os.Parcel
import android.os.Parcelable

//  Used when user click on today city weather

data class CityParcelable(
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

    companion object CREATOR : Parcelable.Creator<CityParcelable> {
        override fun createFromParcel(parcel: Parcel): CityParcelable {
            return CityParcelable(parcel)
        }

        override fun newArray(size: Int): Array<CityParcelable?> {
            return arrayOfNulls(size)
        }
    }
}
