package com.dme.itakua.ui.configuracion

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.dme.itakua.*
import com.dme.itakua.core.Constants
import com.dme.itakua.databinding.FragmentConfiguracionBinding

class ConfiguracionFragment : Fragment() {

    private var _binding: FragmentConfiguracionBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val configuracionViewModel =
            ViewModelProvider(this).get(ConfiguracionViewModel::class.java)

        _binding = FragmentConfiguracionBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //OCULTAR BOTONES
        if(Constants.currentUser.idtipousuario == 2){

            //desactivando y ocultando btn Monto Tarifa y Usuarios
            binding.BtnModificarMontoTarifa.isVisible = false
            binding.BtnUsuarios.isVisible = false
        }


        binding.BtnUsuarios.setOnClickListener {
            startActivity(Intent(activity, UsuarioActivity::class.java))
        }
        binding.BtnModificarMontoTarifa.setOnClickListener {
            startActivity(Intent(activity, PantallaTarifa::class.java))
        }
        binding.BtnRegistrarClienteDatos.setOnClickListener {
            startActivity(Intent(activity, ClientesActivity::class.java))
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    }
