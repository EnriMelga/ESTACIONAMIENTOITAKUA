package com.dme.itakua

import android.content.Intent
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.dme.itakua.core.Constants
import com.dme.itakua.databinding.ActivityCrearUsuarioBinding
import com.dme.itakua.databinding.ActivityEstacionamientoTiempoRealBinding

class EstacTiempoReActivity : AppCompatActivity(){
    private lateinit var binding: ActivityEstacionamientoTiempoRealBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEstacionamientoTiempoRealBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val BASE_URL = Constants.SERVER_HOST+"estacionamiento-ita-kua/index.php?user="+ Constants.currentUser.idusuario+"&v=estacionados"

        binding.WebTiempoReal.webChromeClient = object : WebChromeClient(){

        }
        binding.WebTiempoReal.webViewClient = object : WebViewClient(){

        }
        val settings = binding.WebTiempoReal.settings
        settings.javaScriptEnabled = true

        binding.BackBTN.setOnClickListener {
            finish()
        }
    }
}