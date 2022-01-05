package com.example.ca1.localDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.ca1.data.FavouriteAnime

@Database(entities = [FavouriteAnime::class], version = 2, exportSchema = false)
abstract class AppDB: RoomDatabase() {

    // becomes instantiated and implements the abstract methods in DAO
    abstract fun favouriteDao(): FavouriteDao?

    companion object {

        //create an instance of the APP db
        private var INSTANCE: AppDB? = null

        fun getInstance(context: Context): AppDB? {
            if (INSTANCE == null) {
                synchronized(AppDB::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDB::class.java,
                        //create the favourites database, which is used to store our comments
                        "favourites.db"
                    )
                        .build()
                }
            }

            //returns the instance
            return INSTANCE
        }
    }
}