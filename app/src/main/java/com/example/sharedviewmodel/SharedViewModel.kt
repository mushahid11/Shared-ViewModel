package com.example.sharedviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private var _name = MutableLiveData("ali")
    val name: LiveData<String> get() = _name

    fun saveName(newName: String) {
        _name.value = newName
    }

}