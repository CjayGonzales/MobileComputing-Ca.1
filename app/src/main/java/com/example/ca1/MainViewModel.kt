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
//    init{
//        getPosts()
//    }


    private val _animeList: MutableLiveData<List<AnimeResponse>> = MutableLiveData()
    val animeList = MutableLiveData<AnimeResponse>()

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
    get() = _isLoading

    fun getPosts(){
        //everything is now running in a coroutine block
        viewModelScope.launch {
            _isLoading.value = true
            val fetchedPosts = RetrofitInstance.api.getPosts()
            Log.i("MainViewModel", "fetched posts   :  $fetchedPosts")
            _animeList.value = listOf(fetchedPosts)
            animeList.value = fetchedPosts
            _isLoading.value = false
        }
    }
}