package com.example.ca1.localDatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ca1.data.FavouriteAnime

@Dao
interface FavouriteDao {

    // inserts it when we create, and it replaces things when it is updated
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavourite(favourite: FavouriteAnime)

    // favourites is defined in FavouriteAnime, and is our table name
    @Query("SELECT * FROM favourites WHERE id = :id")

    // ? at the end to allow the object to be null
    fun getFavouriteById(id: Int): FavouriteAnime?

}