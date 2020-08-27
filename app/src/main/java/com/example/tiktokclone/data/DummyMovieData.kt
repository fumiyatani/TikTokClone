package com.example.tiktokclone.data

private const val DUMMY_DATA_SIZE = 3

object DummyMovieData {
    const val dummyDataSize = DUMMY_DATA_SIZE
    val movieData = List(DUMMY_DATA_SIZE) { index ->
        val number = index + 1
        return@List Movie(
            MovieData("A面Title$number", "A面MovieId$number"),
            MovieData("B面Title$number", "B面MovieId$number")
        )
    }
}