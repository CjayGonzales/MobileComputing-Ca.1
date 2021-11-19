package com.example.ca1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ca1.data.AnimeEntity
import com.example.ca1.data.sampleData

class MainViewModel : ViewModel() {
    val animeList = MutableLiveData<List<AnimeEntity>>()

    init{
        animeList.value = sampleData.getAnime()
    }
}