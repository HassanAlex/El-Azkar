package com.codestation.elazkar.ui.fragments.elsabha


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ElsabhaViewModel(
) : ViewModel() {

    // 1- counter mutable liveData
    private val _counterList: MutableLiveData<Int> = MutableLiveData<Int>()

    //2- counter LiveData
    val counterList: LiveData<Int> = _counterList

    private var counter = 0

    fun addNumbersInCounterList() {
        counter++
        _counterList.value = counter
    }

    fun resetCounter() {
        counter = 0
        _counterList.value = counter
    }


}