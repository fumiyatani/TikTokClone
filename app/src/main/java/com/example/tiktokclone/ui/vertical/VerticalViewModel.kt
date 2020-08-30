package com.example.tiktokclone.ui.vertical

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tiktokclone.data.UserRepository
import com.example.tiktokclone.data.entity.Movie
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class VerticalViewModel(private val repository: UserRepository) : ViewModel() {
    private val _movieList = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>>
        get() = _movieList

    fun loadMovieList() {
        viewModelScope.launch {
            delay(2000)
            _movieList.postValue(repository.getMovieData())
        }
    }
}

