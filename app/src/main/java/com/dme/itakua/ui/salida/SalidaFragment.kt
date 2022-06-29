package com.dme.itakua.ui.salida

import android.annotation.SuppressLint
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import androidx.lifecycle.ViewModelProvider
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

        binding.idModoManual.setOnClickListener {
            //Logica para lanzar Menu de Hora Manual
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker: TimePicker, hour:Int, minute:Int ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                binding.HoraModificable.text = SimpleDateFormat("HH:mm").format(cal.time)//Formate de hora
            }
            TimePickerDialog(activity,timeSetListener,cal.get(Calendar.HOUR_OF_DAY),cal.get(Calendar.MINUTE),true).show()
        }

        binding.ImprimirRegistro.setOnClickListener {
            binding.HoraModificable.text=SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime())
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}