package com.dme.itakua

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dme.itakua.databinding.ActivityResumenFinancieronMensualBinding

class ResumenFinancieroMensual : AppCompatActivity() {
    private lateinit var binding: ActivityResumenFinancieronMensualBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResumenFinancieronMensualBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textView14.setOnClickListener {
            Toast.makeText(this@ResumenFinancieroMensual, "Probando...", Toast.LENGTH_SHORT).show()
        }
}
}
