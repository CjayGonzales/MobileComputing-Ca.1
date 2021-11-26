package com.example.ca1.data

import android.os.Parcel
import android.os.Parcelable

class Data (
    val documents: List<Animation>?
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.createTypedArrayList(Animation)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(documents)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Data> {
        override fun createFromParcel(parcel: Parcel): Data {
            return Data(parcel)
        }

        override fun newArray(size: Int): Array<Data?> {
            return arrayOfNulls(size)
        }
    }
}