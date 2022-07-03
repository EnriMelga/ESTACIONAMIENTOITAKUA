package com.dme.itakua

import android.content.Intent
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.dme.itakua.core.Constants
import com.dme.itakua.databinding.ActivityHistoricoBinding
import com.dme.itakua.databinding.ArqueoDeCajaBinding

class HistoricoActivity : AppCompatActivity(){
    private lateinit var binding: ActivityHistoricoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoricoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val BASE_URL = Constants.SERVER_HOST+"estacionamiento-ita-kua/index.php?user="+ Constants.currentUser.idusuario+"&v=historial"

        binding.WebHistorico.webChromeClient = object : WebChromeClient(){

        }
        binding.WebHistorico.webViewClient = object : WebViewClient(){

        }
        val settings = binding.WebHistorico.settings
        settings.javaScriptEnabled = true

        binding.BackBTN.setOnClickListener {
            finish()
        }
    }
}