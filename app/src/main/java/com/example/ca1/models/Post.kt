package com.example.ca1.models

import com.example.ca1.data.Descriptions
import com.example.ca1.data.Titles

data class Post(val id: Int,
                val titles: Titles,
                val descriptions: Descriptions,
                val seasonYear: Int,
                val episodeCount: Int,
                val episodeDuration: Int,
                val trailerUrl: String?,
                val genres: String?,
                val score: Int)