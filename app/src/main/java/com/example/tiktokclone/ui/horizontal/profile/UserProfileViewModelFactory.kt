package com.example.tiktokclone.ui.horizontal.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tiktokclone.data.UserRepository

class UserProfileViewModelFactory(private val repository: UserRepository) :
    ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(UserProfileViewModel::class.java)) {
            UserProfileViewModel(repository) as T
        } else {
            modelClass.newInstance()
        }
    }
}