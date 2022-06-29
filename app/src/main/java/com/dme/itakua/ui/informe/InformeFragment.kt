package com.dme.itakua.ui.informe

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dme.itakua.*
import com.dme.itakua.core.Constants
import com.dme.itakua.databinding.FragmentInformeBinding

class InformeFragment : Fragment() {

    private var _binding: FragmentInformeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val informeViewModel =
            ViewModelProvider(this).get(InformeViewModel::class.java)

        _binding = FragmentInformeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //OCULTAR BOTONES
        if(Constants.currentUser.idtipousuario == 2){//Es funcionario
            //Se le desactiva y oculta los las opciones de Monto Tarifa, Hitoricos y Resumen Financiero
            binding.BtnArqueoDeCaja.isVisible = false
            binding.BtnHistorico.isVisible = false
            binding.BtnResumenFinancieroMensual.isVisible = false
        }

        //Envio a las actividades de acuerdo al boton que pulse
        binding.BtnResumenFinancieroMensual.setOnClickListener {
            startActivity(Intent(activity,ResumenFinancieroMensual::class.java))
        }
        binding.BtnArqueoDeCaja.setOnClickListener {
            startActivity(Intent(activity,ArqueodeCaja::class.java))
        }
        binding.BtnHistorico.setOnClickListener {
            startActivity(Intent(activity,HistoricoActivity::class.java))
        }
        binding.BtnEstacionamientoTiempoReal.setOnClickListener {
            startActivity(Intent(activity,EstacTiempoReActivity::class.java))
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}