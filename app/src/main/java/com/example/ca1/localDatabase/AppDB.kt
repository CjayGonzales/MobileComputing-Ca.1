package com.example.ca1.localDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.ca1.data.FavouriteAnime

@Database(entities = [FavouriteAnime::class], version = 2, exportSchema = false)
abstract class AppDB: RoomDatabase() {
    // this will be instantiated and all the abstract methods in the DAO will be implemented

    abstract fun favouriteDao(): FavouriteDao?

    companion object {
        private var INSTANCE: AppDB? = null

        fun getInstance(context: Context): AppDB? {
            if (INSTANCE == null) {
                synchronized(AppDB::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDB::class.java,
                        "favourites.db"
                    )//.fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}