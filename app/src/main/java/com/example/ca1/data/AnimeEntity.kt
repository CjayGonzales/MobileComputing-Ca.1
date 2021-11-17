package com.example.ca1.data

///////// this is for sample data /////////////////

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

//////// this is for data being called from API //////////////
/*
data class AnimeEntity(
        val data: List<Documents>
)

class Documents(
        val titles: Titles,
        val description: Description,
        val seasonYear: Int,
        val episodeCount: Int,
        val episodeDuration: Int,
        val trailerUrl: String,
        val coverImage: String,
        val score: Int
)

class Titles(
        val enTitle: String,
        val jpTitle: String
)

class Description(
        val enDescription: String
)

*/