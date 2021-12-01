package com.example.ca1.data

import android.os.Parcel
import android.os.Parcelable
//////// this is for data being called from API //////////////

data class AnimeResponse(
        val data: Data?
) : Parcelable {
        constructor(parcel: Parcel) : this(parcel.readParcelable(Data::class.java.classLoader)) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeParcelable(data, flags)
        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<AnimeResponse> {
                override fun createFromParcel(parcel: Parcel): AnimeResponse {
                        return AnimeResponse(parcel)
                }

                override fun newArray(size: Int): Array<AnimeResponse?> {
                        return arrayOfNulls(size)
                }
        }
}
