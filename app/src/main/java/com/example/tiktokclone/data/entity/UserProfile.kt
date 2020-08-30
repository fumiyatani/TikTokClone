package com.example.tiktokclone.data.entity

import java.io.Serializable

data class UserProfile(
    val userId: String,
    val userName: String,
    val userIntroduction: String,
) : Serializable