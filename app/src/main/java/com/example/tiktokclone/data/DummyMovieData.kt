package com.example.tiktokclone.data

private const val DUMMY_DATA_SIZE = 3

object DummyData {
    const val dummyDataSize = DUMMY_DATA_SIZE
    val userData = List(DUMMY_DATA_SIZE) { index ->
        val number = index + 1
        return@List User(
            Movie("title$number", "movieId$number"),
            UserProfile("name$number", "introduction$number")
        )
    }
}