package com.example.ca1.data

data class Animation(
    val id: Int,
    val titles: Titles,
    val description: Descriptions,
    val season_year: Int,
    val episode_count: Int,
    val episode_duration: Int,
    val trailer_url: String,
    val cover_image: String,
    val score: Int
)