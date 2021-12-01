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
//    private val _animations: MutableLiveData<List<Animation>> = MutableLiveData()
//    val animations: LiveData<List<Animation>>
//    get() = _animations
//
//    private val _isLoading = MutableLiveData(false)
//    val isLoading: LiveData<Boolean>
//    get() = _isLoading
//
//


    //private val animeList: MutableLiveData<List<AnimeResponse>> = MutableLiveData()
    private val  animeList: MutableLiveData<List<Animation>> = MutableLiveData()

    val anime: LiveData<List<Animation>>
    get() = animeList

    //runs the function getPosts()
    init{
        getPosts()
    }

//    private val _isLoading = MutableLiveData(false)
//    val isLoading: LiveData<Boolean>
//    get() = _isLoading

    private fun getPosts(){
        //everything is now running in a coroutine block
        viewModelScope.launch {
            //_isLoading.value = true
            val fetchedPosts = RetrofitInstance.api.getPosts()

            //fetched posts is returning null
            Log.i("MainViewModel", "fetched posts   :  ${fetchedPosts.data?.documents?.get(2)?.trailer_url}")
            //_animeList.value = listOf(fetchedPosts)
            animeList.value =fetchedPosts.data?.documents!!
            //_isLoading.value = false
        }
    }
}