package com.example.tiktokclone.data

import com.example.tiktokclone.data.entity.Movie
import com.example.tiktokclone.data.entity.UserProfile

private const val DUMMY_DATA_SIZE = 20

object DummyData {

    val movieData = List(DUMMY_DATA_SIZE) { index ->
        val number = index + 1
        Movie("movieId$number", "title$number", "userId$number")
    }

    val userProfileData = List(DUMMY_DATA_SIZE) { index ->
        val number = index + 1
        UserProfile("userId$number", "userName$number", "userIntroduction$number")
    }
}