package com.dme.itakua.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dme.itakua.IniciarSesion
import com.dme.itakua.PantallaInicio
import com.dme.itakua.R
import com.dme.itakua.core.Constants
import com.dme.itakua.databinding.FragmentHomeBinding

class HomeFragment: Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    //onDestroyView.
    private val binding get() = _binding!!
    var estadoBtnAuto:Boolean = true
    var estadoBtnMoto:Boolean = true
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        /*val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/

        if(Constants.currentUser.idtipousuario==1){
            binding.inputChapa.setText("Prueba admin")
        }
        binding.spinnerTiposervicio.onItemSelectedListener =  object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
              
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        //Boton auto logica y invocaciones
        binding.autoBtn.setImageResource(R.drawable.auto_estacionamiento2)
        binding.autoBtn.setOnClickListener{
            pulsaBtnAuto()
        }

        //Boton moto logica y invicaciones
        binding.motoBtn.setImageResource(R.drawable.moto_estacionamiento2)
        binding.motoBtn.setOnClickListener{
            pulsaBtnMoto()
        }

        return root
    }

    //Funcion encargado de cambiar color de la moto al pulsar
    fun pulsaBtnMoto(){
        if(estadoBtnMoto==true){
            //Cambia la imagen
            binding.motoBtn.setImageResource(R.drawable.moto_estacionamiento3)
            //Cambia estado de boton
            estadoBtnMoto=false
            if(estadoBtnAuto==false){
                binding.autoBtn.setImageResource(R.drawable.auto_estacionamiento2)
                estadoBtnAuto=true
            }
           }else{
            //Cambia la imagen
            binding.motoBtn.setImageResource(R.drawable.moto_estacionamiento2)
            //Cambia estado de boton
            estadoBtnMoto=true
        }
    }

    //Funcion encargado de cambiar color del auto al pulsar
    fun pulsaBtnAuto(){
        if(estadoBtnAuto==true){
            //Cambia la imagen
            binding.autoBtn.setImageResource(R.drawable.auto_estacionamiento3)
            //Cambia estado de boton
            estadoBtnAuto=false
            if(estadoBtnMoto==false){
                binding.motoBtn.setImageResource(R.drawable.moto_estacionamiento2)
                estadoBtnMoto=true
            }
        }else{
            //Cambia la imagen
            binding.autoBtn.setImageResource(R.drawable.auto_estacionamiento2)
            //Cambia estado de boton
            estadoBtnAuto=true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
