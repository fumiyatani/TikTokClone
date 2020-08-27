package com.example.tiktokclone.ui.horizontal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tiktokclone.data.Movie

class HorizontalViewModel : ViewModel() {

    private val _movie: MutableLiveData<Movie> = MutableLiveData()
    val movie: LiveData<Movie>
        get() = _movie

    fun setMovie(movie: Movie) {
        this._movie.postValue(movie)
    }
}