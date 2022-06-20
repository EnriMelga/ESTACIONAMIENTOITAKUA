package com.dme.itakua

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.android.volley.*
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.dme.itakua.core.Constants
import com.dme.itakua.databinding.IniciarSesionBinding
import org.json.JSONException
import org.json.JSONObject
import com.android.volley.toolbox.JsonObjectRequest as JsonObjectRequest1

class IniciarSesion : AppCompatActivity() {
    private lateinit var binding: IniciarSesionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = IniciarSesionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.BtnConfirmarInicio.setOnClickListener{
            invocionLoading()
            validarInicioSesion() //Llamada a validacion
        }
    }

    //Funcion de Conexiones con la API y validacion de Inicio de Sesion
    private fun validarInicioSesion(){

        val NombreUsuario : String = binding.UserName.text.toString()
        val ContraseñaUsuario: String = binding.Password.text.toString()

        //URL de la API en el Servidor
        var url = Constants.SERVER_HOST+"estacionamiento-ita-kua/api/api_login.php"

        var requestQueue:RequestQueue=Volley.newRequestQueue(this)
        var stringRequest:StringRequest = object :StringRequest(Request.Method.POST,url,Response.Listener { response ->
            val obj = JSONObject(response)

            //Mostrar mensaje de respuesta de la API
            Toast.makeText(applicationContext,obj.getString("message"),Toast.LENGTH_LONG).show()
            if(obj.getString("error").equals("false")){ //Inicio de Sesion validado
                startActivity(Intent(this,PantallaInicio::class.java))
            }else{
                startActivity(Intent(this,IniciarSesion::class.java))
            }

        }, Response.ErrorListener { error ->
            Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
            startActivity(Intent(this,IniciarSesion::class.java))
        }){
            //Envio de los datos al Servidor
            override fun getParams(): MutableMap<String, String>? {
                val parms=HashMap<String,String>()
                parms.put("username",NombreUsuario)
                parms.put("pass",ContraseñaUsuario)
                return parms
            }
        }
        requestQueue.add(stringRequest)
        }

    //Funcion para mostrar loading de verificacion
    fun invocionLoading(){
        val progressDialog = ProgressDialog(this@IniciarSesion)
        progressDialog.setTitle("")
        progressDialog.setMessage("Verificando...")
        progressDialog.show()
    }

    }



