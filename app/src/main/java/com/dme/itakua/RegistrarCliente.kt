package com.dme.itakua

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dme.itakua.databinding.RegistrarClienteBinding

class RegistrarCliente : AppCompatActivity() {
    private lateinit var binding: RegistrarClienteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegistrarClienteBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}