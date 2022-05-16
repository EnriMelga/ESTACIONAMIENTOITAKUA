package com.dme.itakua

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.dme.itakua.databinding.ActivityPantallaTarifaBinding
import org.json.JSONArray
import org.json.JSONObject


class PantallaTarifa : AppCompatActivity() {
    private lateinit var binding: ActivityPantallaTarifaBinding
    val rodados: Array<String> = arrayOf("Auto", "Moto")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPantallaTarifaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Parte logica del spinner
        val arrayAdapter = ArrayAdapter(this@PantallaTarifa, R.layout.spinner_dimensiones, rodados)
        binding.tipoDeVehiculo.adapter = arrayAdapter
        binding.tipoDeVehiculo.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    Toast.makeText(
                        this@PantallaTarifa,
                        "Seleccionaste " + rodados[p2],
                        Toast.LENGTH_LONG
                    ).show()
                    mostrarDatos(validarSeleccion(rodados[p2]))
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        modificarMonto()
    }


    private fun modificarMonto() {


        //URL  de la API en el servidor
        var tipoVehiculoSeleccionado:String

        tipoVehiculoSeleccionado = binding.tipoDeVehiculo.selectedItem as String

        var url = validarSeleccion(tipoVehiculoSeleccionado)
        mostrarDatos(url)

    }

    private fun validarSeleccion(tipoVehiculo:String):String{
        var urldir:String
        urldir = if(tipoVehiculo=="Auto"){
            "http://192.168.56.1/itakua/api_tarifas.php?tipovehiculo=1"
        }else{
            "http://192.168.56.1/itakua/api_tarifas.php?tipovehiculo=2"
        }
        return urldir
    }
    private fun mostrarDatos(url:String){

        var requestQueue: RequestQueue = Volley.newRequestQueue(this)
        var stringRequest: StringRequest =
            StringRequest(Request.Method.GET, url, { response ->
                val jsonArray = JSONArray(response)
                for(i in 0 until jsonArray.length()){
                    val jsonObject = JSONObject(jsonArray.getString(i))
                    when(i){
                        0 -> binding.horaTarifa.setText(jsonObject.get("precio").toString())
                        1 -> binding.diaTarifa.setText(jsonObject.get("precio").toString())
                        2 -> binding.semanaTarifa.setText(jsonObject.get("precio").toString())
                        3 -> binding.mesTarifa.setText(jsonObject.get("precio").toString())
                    }
                }
            }, { error ->
                Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()
            })
        requestQueue.add(stringRequest)
    }
}