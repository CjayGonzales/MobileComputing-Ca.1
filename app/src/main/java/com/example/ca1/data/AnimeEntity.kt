package com.example.ca1.data

data class AnimeEntity (
        val id: Int,
        val titles: String, //array
        val descriptions: String, //also array
        val seasonYear: Int,
        val episodeCount: Int,
        val episodeDuration: Int,
        val trailerUrl: String,
        val genres: String, //array
        val score: Int

)