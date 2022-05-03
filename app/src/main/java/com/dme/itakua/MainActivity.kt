package com.dme.itakua

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dme.itakua.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.BtnConfirmarInicio.setOnClickListener{
            startActivity(Intent(this,CrearUsuario::class.java))
        }
    }
    private fun ejecutarServicio(){
        val NombreUsuario : String = binding.UserName.text.toString()
        val ContraseñaUsuario: String = binding.PasswordName.text.toString()
    }
}
