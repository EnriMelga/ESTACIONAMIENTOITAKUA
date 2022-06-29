package com.dme.itakua.ui.home

import android.annotation.SuppressLint
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dme.itakua.R
import com.dme.itakua.databinding.FragmentHomeBinding
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

        binding.ModoManual.setOnClickListener {
            //Logica para lanzar Menu de Hora Manual
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker:TimePicker, hour:Int, minute:Int ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                binding.HoraModificable.text = SimpleDateFormat("HH:mm").format(cal.time)//Formato de hora
            }
        TimePickerDialog(activity,timeSetListener,cal.get(Calendar.HOUR_OF_DAY),cal.get(Calendar.MINUTE),true).show()
        }
        //Seleccion Item de tipo de Servicio horario
        binding.spinnerTiposervicio.onItemSelectedListener =  object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        //Boton auto logica y invocaciones
        binding.autoBtn.setImageResource(R.drawable.ic_auto)
        binding.autoBtn.setOnClickListener{
            pulsaBtnAuto()
        }
        //Boton moto logica y invicaciones
        binding.motoBtn.setImageResource(R.drawable.ic_moto)
        binding.motoBtn.setOnClickListener{
            pulsaBtnMoto()
        }
        binding.ImprimirRegistro.setOnClickListener {
            binding.HoraModificable.text=SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime())
            if(estadoBtnAuto == true && estadoBtnMoto==true){//Comprobacion de que selecciona el tipo de vehiculo
                Toast.makeText(activity,"Selecciona el tipo de vehiculo a registrarr", Toast.LENGTH_LONG).show()
            }
        }
        return root
    }
    //Funcion encargado de cambiar color de la moto al pulsar
    fun pulsaBtnMoto(){
        if(estadoBtnMoto==true){
            //Cambia la imagen a ser pulsado
            binding.motoBtn.setImageResource(R.drawable.ic_moto_seleccionado)
            //Cambia estado de boton
            estadoBtnMoto=false
            if(estadoBtnAuto==false){//Cambia el estado
                binding.autoBtn.setImageResource(R.drawable.ic_auto)
                estadoBtnAuto=true
            }
           }else{
            //Cambia la imagen
            binding.motoBtn.setImageResource(R.drawable.ic_moto)
            //Cambia estado de boton
            estadoBtnMoto=true
        }
    }
    //Funcion encargado de cambiar color del auto al pulsar
    fun pulsaBtnAuto(){
        if(estadoBtnAuto==true){
            //Cambia la imagen
            binding.autoBtn.setImageResource(R.drawable.ic_auto_seleccionado)
            //Cambia estado de boton
            estadoBtnAuto=false
            if(estadoBtnMoto==false){
                binding.motoBtn.setImageResource(R.drawable.ic_moto)
                estadoBtnMoto=true
            }
        }else{
            //Cambia la imagen
            binding.autoBtn.setImageResource(R.drawable.ic_auto)
            //Cambia estado de boton
            estadoBtnAuto=true
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
