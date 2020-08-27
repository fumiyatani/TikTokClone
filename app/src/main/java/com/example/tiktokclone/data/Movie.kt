package com.example.tiktokclone.data

import java.io.Serializable

data class Movie(
    val aMovie: VideoData,
    val bMovie: VideoData
) : Serializable