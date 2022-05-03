package com.dme.itakua

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.get
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonRequest
import com.android.volley.toolbox.StringRequest
import com.dme.itakua.databinding.ActivityCrearUsuarioBinding
import org.json.JSONException
import org.json.JSONObject
import kotlin.Throws



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
        var tipoUsuario:String = binding.TipoUsuarioSpinner.selectedItem.toString()


        //Creando volley String Request
        val url = "http://localhost/itakua/api_registrarse.php"

        val stringRequest = object : StringRequest(Request.Method.POST,url,
        Response.Listener<String> { response ->
            try {
                val obj = JSONObject(response)
                Toast.makeText(applicationContext,obj.getString("message"),Toast.LENGTH_LONG).show()
            }catch (e:JSONException){
                e.printStackTrace()
            }

        },
        Response.ErrorListener { volleyError -> Toast.makeText(applicationContext, volleyError.message,Toast.LENGTH_LONG).show() }){
            @Throws(AuthFailureError::class)

            //Envio de validaciones en la BD
            override fun getParams(): Map<String,String> {
                val params = HashMap<String,String>()
                params.put("username",Nombre_de_Usuario)
                params.put("nombrecompleto",Nombre_Usuario_Completo)
                params.put("pass",Contraseña)
                params.put("confirmpass",ConfirmarContraseña)
                if(tipoUsuario=="Administrador"){
                    val UsuarioAdministrador:Int=1
                    params.put("tipoUsuario", UsuarioAdministrador.toString())
                }else{
                    val UsuarioFuncionario:Int=2
                    params.put("tipoUsuario",UsuarioFuncionario.toString())
                }
                return params
            }
        }
       //Ading request to queve
      VolleySingleton.instance?.addToRequestQueve(stringRequest)
    }

}