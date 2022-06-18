package com.dme.itakua

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dme.itakua.databinding.ActivityCrearUsuarioBinding
import com.dme.itakua.databinding.UsuariosRegistradosBinding

class UsuarioActivity : AppCompatActivity() {
    private lateinit var binding:UsuariosRegistradosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = UsuariosRegistradosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.BtnRegistrarUsuario.setOnClickListener {
        startActivity(Intent(this,CrearUsuario::class.java))
        }
    }
}