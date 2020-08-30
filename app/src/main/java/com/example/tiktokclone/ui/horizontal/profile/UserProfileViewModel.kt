package com.example.tiktokclone.ui.horizontal.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tiktokclone.data.UserRepository
import com.example.tiktokclone.data.entity.UserProfile
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class UserProfileViewModel(private val repository: UserRepository) : ViewModel() {
    private val _userProfile = MutableLiveData<UserProfile>()
    val userProfile: LiveData<UserProfile>
        get() = _userProfile

    fun getUserProfile(userId: String) {
        viewModelScope.launch {
            delay(1000)
            _userProfile.postValue(repository.getUserProfile(userId))
        }
    }
}

