package com.example.ca1.data

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
// we can check the comments of the anime in the app inspection, while the app is running
@Entity (tableName = "favourites")
data class FavouriteAnime (
    @PrimaryKey val id: Int,
    var myNotes : String
)