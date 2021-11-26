package com.example.ca1.data

import android.os.Parcel
import android.os.Parcelable

data class Animation(
    val id: Int,
    val titles: Titles?,
    val description: Descriptions?,
    val season_year: Int,
    val episode_count: Int,
    val episode_duration: Int,
    val trailer_url: String?,
    val cover_image: String?,
    val score: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readParcelable(Titles::class.java.classLoader),
        parcel.readParcelable(Descriptions::class.java.classLoader),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeParcelable(titles, flags)
        parcel.writeParcelable(description, flags)
        parcel.writeInt(season_year)
        parcel.writeInt(episode_count)
        parcel.writeInt(episode_duration)
        parcel.writeString(trailer_url)
        parcel.writeString(cover_image)
        parcel.writeInt(score)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Animation> {
        override fun createFromParcel(parcel: Parcel): Animation {
            return Animation(parcel)
        }

        override fun newArray(size: Int): Array<Animation?> {
            return arrayOfNulls(size)
        }
    }
}