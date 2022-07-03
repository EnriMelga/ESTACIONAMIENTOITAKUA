package com.dme.itakua.ui.salida

import android.annotation.SuppressLint
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import android.widget.TimePicker
import androidx.lifecycle.ViewModelProvider
import com.dme.itakua.core.Constants
import com.dme.itakua.databinding.FragmentHomeBinding
import com.dme.itakua.databinding.FragmentSalidaBinding
import com.dme.itakua.ui.home.HomeViewModel
import java.text.SimpleDateFormat


class SalidaFragment : Fragment() {

    private var _binding: FragmentSalidaBinding? = null
    private val binding get() = _binding!!

    @SuppressLint("NewApi")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val salidaViewModel = ViewModelProvider(this).get(SalidaViewModel::class.java)
        _binding = FragmentSalidaBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val BASE_URL = Constants.SERVER_HOST+"estacionamiento-ita-kua/index.php?user="+ Constants.currentUser.idusuario+"&v=salida"
        super.onCreate(savedInstanceState)



        binding.WebSalida.webChromeClient = object : WebChromeClient(){

        }
        binding.WebSalida.webViewClient = object : WebViewClient(){

        }
        val settings = binding.WebSalida.settings
        settings.javaScriptEnabled = true

        binding.WebSalida.loadUrl(BASE_URL)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}