package com.dme.itakua

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.android.volley.*
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.dme.itakua.databinding.ActivityCrearUsuarioBinding
import org.json.JSONObject



class CrearUsuario : AppCompatActivity() {
    private lateinit var binding: ActivityCrearUsuarioBinding

    //Creacion de sppinner de tipo de Usuario
    val tipoUsuario: Array<String> = arrayOf("Administrador", "Funcionario")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrearUsuarioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Parte logica del sppiner
        val arrayAdapter = ArrayAdapter(this@CrearUsuario,R.layout.spinner_dimensiones,tipoUsuario)

        binding.TipoUsuarioSpinner.adapter = arrayAdapter
        binding.TipoUsuarioSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(this@CrearUsuario,"Has seleccionado " +tipoUsuario[p2],Toast.LENGTH_LONG).show()
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }//Fin de parte logica del spinner

        binding.BtnConfirmarRegistro.setOnClickListener {
            ConexionBDRegistrarUsuario()
        }
    }
    //Conexiones y almacenamiento con la BD
    private fun ConexionBDRegistrarUsuario(){

        val Nombre_de_Usuario: String = binding.CrearNuevoUsuario.text.toString()
        val Nombre_Usuario_Completo: String = binding.CrearUsuario.text.toString()
        val Contraseña: String = binding.CrearContraseA.text.toString()
        val ConfirmarContraseña:String = binding.ConfirmarContraseA.text.toString()
        var tipoUsuario: Int

        //Chequeo de si selecciono Funcionario o Administrador
        tipoUsuario = if(binding.TipoUsuarioSpinner.selectedItem=="Administrador") {
            1
        }else{
            2
        }

        //URL de la API en el Servidor
        val url = "http://192.168.56.1/estacionamiento-ita-kua/api/api_registrarse.php"

        var requestQueue: RequestQueue = Volley.newRequestQueue(this)
        var stringRequest:StringRequest = object :StringRequest(Request.Method.POST,url,Response.Listener { response ->
            val obj = JSONObject(response)

            //Mostrar mensaje de respuesta de la API
            Toast.makeText(applicationContext,obj.getString("message"),Toast.LENGTH_LONG).show()
            if(obj.getString("error").equals("false")){
                limpiar()
            }
        }, Response.ErrorListener { error ->
            Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
        }){
            override fun getParams(): MutableMap<String, String>? {//Envio de validaciones en la BD
                val parms=HashMap<String,String>()
                parms.put("username",Nombre_de_Usuario)
                parms.put("nombrecompleto",Nombre_Usuario_Completo)
                parms.put("pass",Contraseña)
                parms.put("confirmpass",ConfirmarContraseña)
                parms.put("tipoUsuario",tipoUsuario.toString())
                return parms
            }
        }
        requestQueue.add(stringRequest)
    }
    //Vacia los las escrituras caso se confirme registro del Usuario
    private fun limpiar(){
        binding.CrearNuevoUsuario.setText("")
        binding.CrearUsuario.setText("")
        binding.ConfirmarContraseA.setText("")
        binding.CrearContraseA.setText("")
    }
}