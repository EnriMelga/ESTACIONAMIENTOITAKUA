package com.dme.itakua

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dme.itakua.databinding.ActivityCrearUsuarioBinding
import com.dme.itakua.databinding.ActivityEstacionamientoTiempoRealBinding

class EstacTiempoReActivity : AppCompatActivity(){
    private lateinit var binding: ActivityEstacionamientoTiempoRealBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEstacionamientoTiempoRealBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}