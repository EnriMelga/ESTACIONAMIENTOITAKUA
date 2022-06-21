package com.dme.itakua

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import com.dme.itakua.core.Constants
import com.dme.itakua.databinding.ActivityClientesBinding
import com.dme.itakua.databinding.IniciarSesionBinding

class ClientesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityClientesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        val BASE_URL = Constants.SERVER_HOST+"/estacionamiento-ita-kua/view/cliente/mostrarClientes.php"
        super.onCreate(savedInstanceState)
        binding = ActivityClientesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.BtnRegistrarClientes.setOnClickListener {
            startActivity(Intent(this,RegistrarCliente::class.java))
        }

        binding.webListarClientes.webChromeClient = object : WebChromeClient(){

        }
        binding.webListarClientes.webViewClient = object : WebViewClient(){

        }
        val settings = binding.webListarClientes.settings
        settings.javaScriptEnabled = true

        binding.webListarClientes.loadUrl(BASE_URL)

        fun onBackPressed(){
//            if(binding.webListarClientes.canGoBack()){
            super.onBackPressed()
            //          }
        }
    }
}