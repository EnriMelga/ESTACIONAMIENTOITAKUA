package com.dme.itakua

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dme.itakua.databinding.ActivityPantallaInicioBinding
import com.dme.itakua.databinding.SpinnerDimensionesBinding.inflate


class PantallaInicio : AppCompatActivity() {
    private lateinit var binding: ActivityPantallaInicioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPantallaInicioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.BtnAbrirRegistrarUsuario.setOnClickListener {
            startActivity(Intent(this,PantallaTarifa::class.java))
        }

    }
}