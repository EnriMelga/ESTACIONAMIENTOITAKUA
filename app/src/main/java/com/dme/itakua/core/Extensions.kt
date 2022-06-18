package com.dme.itakua.core

import android.app.Activity
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast

//para verificar si algun dato es nulo -> dato.isNull()
fun Any?.isNull() = this == null

//mostrar Toast
/*

 */
fun Activity.showToast(text: String?, lenght:Int = Toast.LENGTH_LONG){
    Toast.makeText(this, text, lenght).show()
}

// on text changed
/*
    para agregar un listener a un EditText
    metodo escrito para tener referencia y poder implementar otros metodos similares
    para info: video YT funciones de extension aristidev
 */
fun EditText.onTextChanged(listener:(String)-> Unit){
    this.addTextChangedListener(object : TextWatcher {

        override fun afterTextChanged(s: Editable?) {
            listener(s.toString())
        }
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
    })
}