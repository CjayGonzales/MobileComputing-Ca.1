package com.example.ca1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ca1.data.AnimeEntity
import com.example.ca1.data.sampleData

class MainViewModel : ViewModel() {
    val notesList = MutableLiveData<List<AnimeEntity>>()

    init{
        notesList.value = sampleData.getAnime()
    }
}