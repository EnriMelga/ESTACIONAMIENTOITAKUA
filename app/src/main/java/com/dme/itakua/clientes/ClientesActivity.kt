package com.dme.itakua.clientes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import com.dme.itakua.core.Constants
import com.dme.itakua.databinding.ActivityClientesBinding

class ClientesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityClientesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        val BASE_URL = Constants.SERVER_HOST+"/estacionamiento-ita-kua/index.php?user="+Constants.currentUser.idusuario+"&v=mostrarclientes"
        super.onCreate(savedInstanceState)
        binding = ActivityClientesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.BackBTN2.setOnClickListener {
            finish()
        }
        binding.BtnRegistrarClientes.setOnClickListener {
            startActivity(Intent(this, RegistrarCliente::class.java))
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