package com.example.tiktokclone.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * 縦方向のスクロールの制御を行うためのViewModel
 * 複数のFragment間で使用されることを想定している。
 */
class VerticalScrollViewModel : ViewModel() {
    private val _canVerticalScroll: MutableLiveData<Boolean> = MutableLiveData()
    val canVerticalScroll: LiveData<Boolean>
        get() = _canVerticalScroll

    /**
     * スクロール制御を行う
     *
     * @param canVerticalScroll スクロール制御 true:スクロール可能
     */
    fun setCanVerticalScroll(canVerticalScroll: Boolean) {
        this._canVerticalScroll.postValue(canVerticalScroll)
    }
}