package com.example.tiktokclone.data

import java.io.Serializable

data class User(
    val movie: Movie,
    val profile: UserProfile
) : Serializable

data class Movie(
    val title: String,
    val movieId: String
) : Serializable

data class UserProfile(
    val name: String,
    val introduction: String
) : Serializable