package com.example.ca1.data

import android.os.Parcel
import android.os.Parcelable

data class Descriptions(val en: String?) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(en)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Descriptions> {
        override fun createFromParcel(parcel: Parcel): Descriptions {
            return Descriptions(parcel)
        }

        override fun newArray(size: Int): Array<Descriptions?> {
            return arrayOfNulls(size)
        }
    }
}