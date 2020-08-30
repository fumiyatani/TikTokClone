package com.example.tiktokclone.data.entity

import java.io.Serializable

data class Movie(
    val movieId: String,
    val movieTitle: String,
    val userId: String,
) : Serializable