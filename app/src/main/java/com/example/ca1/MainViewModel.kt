package com.example.ca1

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ca1.api.RetrofitInstance
import com.example.ca1.data.Animation
import com.example.ca1.data.AnimeResponse
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val  animeList: MutableLiveData<List<Animation>> = MutableLiveData()

    val anime: LiveData<List<Animation>>
    get() = animeList

    //runs the function getPosts()
    init{
        getPosts()
    }

    private fun getPosts(){

        //everything is now running in a coroutine block
        viewModelScope.launch {
            val fetchedPosts = RetrofitInstance.api.getPosts()

            Log.i("MainViewModel", "fetched posts   :  ${fetchedPosts.data?.documents?.get(2)?.trailer_url}")
            animeList.value = fetchedPosts.data?.documents!!
        }
    }
}