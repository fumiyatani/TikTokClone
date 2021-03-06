package com.example.tiktokclone.ui.vertical

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tiktokclone.data.Movie

class VerticalViewModel : ViewModel() {

    private val _canVerticalScroll: MutableLiveData<Boolean> = MutableLiveData(false)
    val canVerticalScroll: LiveData<Boolean>
        get() = _canVerticalScroll

    fun setCanVerticalScroll(canVerticalScroll: Boolean) {
        this._canVerticalScroll.postValue(canVerticalScroll)
    }
}