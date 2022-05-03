package com.dme.itakua

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.dme.itakua.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding
    val rodados: Array<String> = arrayOf("Auto", "Moto")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //Parte logica del spinner
        val arrayAdapter = ArrayAdapter(this@MainActivity3, R.layout.spinner_dimensiones, rodados)
        binding.spinner.adapter = arrayAdapter
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(this@MainActivity3, "Seleccionaste " + rodados[p2], Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}