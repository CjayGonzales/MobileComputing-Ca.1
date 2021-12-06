package com.example.ca1.localDatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ca1.data.FavouriteAnime

@Dao
interface FavouriteDao {

    // inserts when creating, replaces when updating
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavourite(favourite: FavouriteAnime)

    // favourites is defined in FavouriteAnime as the table name
    @Query("SELECT * FROM favourites WHERE id = :id")

    // ? at the end since the object can be null
    fun getFavouriteById(id: Int): FavouriteAnime?

}