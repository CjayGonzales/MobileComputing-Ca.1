package com.example.ca1.data

import android.os.Parcel
import android.os.Parcelable

data class Titles(val enTitle: String?,
                  val jpTitle: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(enTitle)
        parcel.writeString(jpTitle)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Titles> {
        override fun createFromParcel(parcel: Parcel): Titles {
            return Titles(parcel)
        }

        override fun newArray(size: Int): Array<Titles?> {
            return arrayOfNulls(size)
        }
    }
}