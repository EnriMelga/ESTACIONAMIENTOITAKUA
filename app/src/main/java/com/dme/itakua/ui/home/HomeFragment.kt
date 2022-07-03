package com.dme.itakua.ui.home

import android.annotation.SuppressLint
import android.app.TimePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dme.itakua.CrearUsuario
import com.dme.itakua.R
import com.dme.itakua.core.Constants
import com.dme.itakua.databinding.FragmentHomeBinding
import com.dme.itakua.databinding.UsuariosRegistradosBinding
import java.text.SimpleDateFormat

class HomeFragment: Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    //onDestroyView.
    private val binding get() = _binding!!
    var estadoBtnAuto:Boolean = true
    var estadoBtnMoto:Boolean = true

    @SuppressLint("SimpleDateFormat")
    @RequiresApi(Build.VERSION_CODES.N)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val BASE_URL = Constants.SERVER_HOST+"estacionamiento-ita-kua/index.php?user="+ Constants.currentUser.idusuario+"&v=entrada"
        super.onCreate(savedInstanceState)

        binding.WebHome.webChromeClient = object : WebChromeClient(){

        }
        binding.WebHome.webViewClient = object : WebViewClient(){

        }
        val settings = binding.WebHome.settings
        settings.javaScriptEnabled = true

        binding.WebHome.loadUrl(BASE_URL)

//        fun onBackPressed(){
  //          if(binding.webListarClientes.canGoBack()){
    //        super.onBackPressed()
            //          }
      //  }

       return root
}
    }
