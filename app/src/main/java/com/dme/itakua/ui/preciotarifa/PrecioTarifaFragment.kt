package com.dme.itakua.ui.preciotarifa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.dme.itakua.R
import com.dme.itakua.core.Constants
import com.dme.itakua.databinding.FragmentPrecioTarifaBinding
import org.json.JSONArray
import org.json.JSONObject

class PrecioTarifaFragment : Fragment() {

    val rodados: Array<String> = arrayOf("Auto", "Moto")

    private var _binding: FragmentPrecioTarifaBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val precioTarifaViewModel =
            ViewModelProvider(this).get(PrecioTarifaViewModel::class.java)

        _binding = FragmentPrecioTarifaBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val arrayAdapter = ArrayAdapter(requireActivity(), R.layout.spinner_dimensiones, rodados)
        binding.spinnerTipoVehiculo.adapter = arrayAdapter
        binding.spinnerTipoVehiculo.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    //Actualizar datos segun el tipo de vahiculo seleccionado
                    mostrarDatos(validarSeleccion(rodados[p2]))
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        modificarMonto()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun modificarMonto() {
        //URL  de la API en el servidor
        var tipoVehiculoSeleccionado:String

        tipoVehiculoSeleccionado = binding.spinnerTipoVehiculo.selectedItem as String

        var url = validarSeleccion(tipoVehiculoSeleccionado)
        mostrarDatos(url)
    }

    //Recibir los precios segun seleccione el Usuario
    private fun validarSeleccion(tipoVehiculo:String):String{
        var urldir:String
        urldir = if(tipoVehiculo=="Auto"){
            Constants.SERVER_HOST+"estacionamiento-ita-kua/api/api_tarifas.php?tipovehiculo=1"
        }else{
            Constants.SERVER_HOST+"estacionamiento-ita-kua/api/api_tarifas.php?tipovehiculo=2"
        }
        return urldir
    }

    //Conexion con el servidor y lectura de Json y distribucion en los campos correspondientes
    private fun mostrarDatos(url:String){

        var requestQueue: RequestQueue = Volley.newRequestQueue(activity)
        var stringRequest: StringRequest =
            StringRequest(Request.Method.GET, url, { response ->
                val jsonArray = JSONArray(response)
                for(i in 0 until jsonArray.length()){
                    val jsonObject = JSONObject(jsonArray.getString(i))
                    when(i){//Cada numero posee el precio de acuerdo al horario
                        0 -> binding.horaTarifa.setText(jsonObject.get("precio").toString())
                        1 -> binding.diaTarifa.setText(jsonObject.get("precio").toString())
                        2 -> binding.semanaTarifa.setText(jsonObject.get("precio").toString())
                        3 -> binding.mesTarifa.setText(jsonObject.get("precio").toString())
                    }
                }
            }, { error ->
                //Error caso exista un problema de conexion
                Toast.makeText(activity, error.message, Toast.LENGTH_LONG).show()
            })
        requestQueue.add(stringRequest)
    }

}