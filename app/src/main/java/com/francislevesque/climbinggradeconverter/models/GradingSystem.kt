package com.francislevesque.climbinggradeconverter.models

import android.os.Parcel
import android.os.Parcelable
import com.francislevesque.climbinggradeconverter.services.DataService

class GradingSystem(val name: String? = "", val image: String? = "", val subtext: String? = "") : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(image)
        parcel.writeString(subtext)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GradingSystem> {
        override fun createFromParcel(parcel: Parcel): GradingSystem {
            return GradingSystem(parcel)
        }

        override fun newArray(size: Int): Array<GradingSystem?> {
            return arrayOfNulls(size)
        }
    }

    fun dataset() : List<Grade> {
        return DataService.fetchGrades(name)
    }
}