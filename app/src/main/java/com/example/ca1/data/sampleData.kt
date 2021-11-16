package com.example.ca1.data
import java.util.*

class sampleData {
    companion object {
        private val sampleAnimeTitle1 = "Gintama"
        private val sampleAnimeTitle2 = "Terror in Resonance"
        private val sampleAnimeTitle3 = "Demon Slayer"

        private val sampleAnimeDesc1 = "Testing Description 1"
        private val sampleAnimeDesc2 = "Testing Description 2"
        private val sampleAnimeDesc3 = "Testing Description 3"

        private val seasonYear1 = 2019
        private val seasonYear2 = 2020
        private val seasonYear3 = 2021

        private val episodeCount1 = 200
        private val episodeCount2 = 200
        private val episodeCount3 = 200

        private val duration1 = 24
        private val duration2 = 24
        private val duration3 = 24

        private val trailerURL1 = "trailerURLexample1"
        private val trailerURL2 = "trailerURLexample2"
        private val trailerURL3 = "trailerURLexample3"

        private val genres1 = "action"
        private val genres2 = "adventure"
        private val genres3 = "misery"

        private val score1 = 93
        private val score2 = 99
        private val score3 = 89

        fun getAnime() = arrayListOf(
            AnimeEntity(1,sampleAnimeTitle1, sampleAnimeDesc1, seasonYear1, episodeCount1, duration1, trailerURL1, genres1, score1),
            AnimeEntity(2, sampleAnimeTitle2, sampleAnimeDesc2, seasonYear2, episodeCount2, duration2, trailerURL2, genres2, score2),
            AnimeEntity(3, sampleAnimeTitle3, sampleAnimeDesc3, seasonYear3, episodeCount3, duration3, trailerURL3, genres3, score3)

            )






    }
}
