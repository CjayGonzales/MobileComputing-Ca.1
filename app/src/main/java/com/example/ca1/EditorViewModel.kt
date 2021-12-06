package com.example.ca1

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ca1.data.FavouriteAnime
import com.example.ca1.localDatabase.AppDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EditorViewModel (app: Application) : AndroidViewModel(app) {
    private val database = AppDB.getInstance(app)
    val currentFavourite = MutableLiveData<FavouriteAnime>()

    fun getFavourite(favouriteId: Int) {
        Log.i(TAG_2, "Id : " + favouriteId)
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val favourite =
                    database?.favouriteDao()?.getFavouriteById(favouriteId)

                favourite?.let {
                    currentFavourite.postValue(it)
                    Log.i(TAG_2, "MyNotes Returned from DB" + it.myNotes)
                }
            }
        }
    }
    fun saveFavourite(favouriteAnime: FavouriteAnime) {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                database?.favouriteDao()?.insertFavourite(favouriteAnime)
            }
        }
    }
}