package com.dme.itakua

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dme.itakua.databinding.ActivityFacturaLegalBinding
import com.dme.itakua.databinding.ActivityPantallaInicioBinding

class FacturaLegal : AppCompatActivity() {
    private lateinit var binding: ActivityFacturaLegalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_factura_legal)
        binding = ActivityFacturaLegalBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}