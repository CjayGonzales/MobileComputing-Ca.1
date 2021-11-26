package com.example.ca1.data

import android.os.Parcel
import android.os.Parcelable

///////// this is for sample data /////////////////
/*
data class AnimeEntity(
        val id: Int,
        val titles: String?, //array
        val descriptions: String?, //also array
        val seasonYear: Int,
        val episodeCount: Int,
        val episodeDuration: Int,
        val trailerUrl: String?,
        val genres: String?, //array
        val score: Int
) : Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readInt(),
                parcel.readString(),
                parcel.readString(),
                parcel.readInt(),
                parcel.readInt(),
                parcel.readInt(),
                parcel.readString(),
                parcel.readString(),
                parcel.readInt()
        ) {
        }

        constructor() : this(NEW_ANIME_ID, "", "", 0, 0, 0, "", "", 0)

        constructor(titles: String,
                    descriptions: String,
                    seasonYear: Int,
                    episodeCount: Int,
                    episodeDuration: Int,
                    trailerUrl: String?,
                    genres: String?,
                    score: Int) : this(NEW_ANIME_ID,
                                        titles,
                                        descriptions,
                                        seasonYear,
                                        episodeCount,
                                        episodeDuration,
                                        trailerUrl,
                                        genres,
                                        score)

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeInt(id)
                parcel.writeString(titles)
                parcel.writeString(descriptions)
                parcel.writeInt(seasonYear)
                parcel.writeInt(episodeCount)
                parcel.writeInt(episodeDuration)
                parcel.writeString(trailerUrl)
                parcel.writeString(genres)
                parcel.writeInt(score)
        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<AnimeEntity> {
                override fun createFromParcel(parcel: Parcel): AnimeEntity {
                        return AnimeEntity(parcel)
                }

                override fun newArray(size: Int): Array<AnimeEntity?> {
                        return arrayOfNulls(size)
                }
        }

}
*/
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
