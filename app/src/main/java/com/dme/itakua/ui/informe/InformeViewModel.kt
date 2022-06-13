package com.dme.itakua.ui.informe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InformeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is informe Fragment"
    }
    val text: LiveData<String> = _text
}