package com.example.tiktokclone.ui.vertical

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tiktokclone.data.UserRepository
import java.lang.IllegalArgumentException

class VerticalViewModelFactory(private val repository: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return if (modelClass.isAssignableFrom(VerticalViewModel::class.java)) {
            VerticalViewModel(repository) as T
        } else {
            throw IllegalArgumentException("unknown class argument")
        }
    }
}