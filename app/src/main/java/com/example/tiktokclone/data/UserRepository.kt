package com.example.tiktokclone.data

object UserRepository {

    suspend fun getMovieData() = DummyData.movieData

    suspend fun getUserProfile(userId: String) =
        DummyData.userProfileData.first { it.userId == userId }
}