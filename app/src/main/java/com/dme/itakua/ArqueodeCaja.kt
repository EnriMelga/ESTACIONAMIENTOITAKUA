package com.dme.itakua

import android.content.Intent
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.dme.itakua.core.Constants
import com.dme.itakua.databinding.ArqueoDeCajaBinding

class ArqueodeCaja : AppCompatActivity(){
    private lateinit var binding: ArqueoDeCajaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ArqueoDeCajaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val BASE_URL = Constants.SERVER_HOST+"estacionamiento-ita-kua/index.php?user="+ Constants.currentUser.idusuario+"&v=apertura"

        binding.WebArqueoDeCaja.webChromeClient = object : WebChromeClient(){

        }
        binding.WebArqueoDeCaja.webViewClient = object : WebViewClient(){

        }
        val settings = binding.WebArqueoDeCaja.settings
        settings.javaScriptEnabled = true

        binding.WebArqueoDeCaja.loadUrl(BASE_URL)
        binding.BackBTN.setOnClickListener {
            finish()
        }
    }
}