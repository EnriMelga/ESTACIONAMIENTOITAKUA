package com.dme.itakua.ui.preciotarifa

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PrecioTarifaViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is preciotarifa Fragment"
    }
    val text: LiveData<String> = _text
}