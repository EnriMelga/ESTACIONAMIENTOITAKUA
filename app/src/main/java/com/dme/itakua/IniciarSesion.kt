package com.dme.itakua

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.dme.itakua.databinding.IniciarSesionBinding
import org.json.JSONException
import org.json.JSONObject

class IniciarSesion : AppCompatActivity() {
    private lateinit var binding: IniciarSesionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = IniciarSesionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.BtnConfirmarInicio.setOnClickListener{
          ejecutarServicio()
        }
    }

    //Conexiones con la BD y validacion de Inicio de Sesion
    private fun ejecutarServicio(){
        //Toast.makeText(applicationContext,"Boton Presionado",Toast.LENGTH_LONG).show()

        val NombreUsuario : String = binding.UserName.text.toString()
        val ContraseñaUsuario: String = binding.Password.text.toString()

        val url = "http://localhost/itakua/api_login.php"

        val stringRequest = object : StringRequest(Request.Method.POST,url,
        Response.Listener<String> { response ->

        //val request = JsonObjectRequest(Request.Method.POST,url,jsonObject,)
            try {
                val obj = JSONObject(response)
                Toast.makeText(applicationContext,obj.getString("message"),Toast.LENGTH_LONG).show()
                Toast.makeText(applicationContext,"Conectado",Toast.LENGTH_LONG).show()

            }catch (e:JSONException){
                e.printStackTrace()
                Toast.makeText(applicationContext,"Error conect",Toast.LENGTH_LONG).show()

            }
        },
        Response.ErrorListener { volleyError -> Toast.makeText(applicationContext, volleyError.message,Toast.LENGTH_LONG).show() }) {
            @Throws(AuthFailureError::class)
        )

            //Envio de Usuario y contraseña a la BD
            override fun getParams(): Map<String, String> {
                val params = HashMap<String,String>()
                params.put("username",NombreUsuario)
                params.put("pass",ContraseñaUsuario)
                return params
            }
        }
        VolleySingleton.instance?.addToRequestQueve(stringRequest)
    }
}
