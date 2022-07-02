package com.dme.itakua

import android.content.Intent
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.dme.itakua.core.Constants
import com.dme.itakua.databinding.ActivityCrearUsuarioBinding
import com.dme.itakua.databinding.UsuariosRegistradosBinding

class UsuarioActivity : AppCompatActivity() {
    private lateinit var binding:UsuariosRegistradosBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        val BASE_URL = Constants.SERVER_HOST+"estacionamiento-ita-kua/index.php?user="+Constants.currentUser.idusuario+"&v=usuarios"
        super.onCreate(savedInstanceState)
        binding = UsuariosRegistradosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.BackBTN.setOnClickListener {
            finish()
        }
        binding.BtnRegistrarUsuario.setOnClickListener {
            startActivity(Intent(this,CrearUsuario::class.java))
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