package com.dme.itakua.clientes

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.dme.itakua.core.Constants
import com.dme.itakua.databinding.RegistrarClienteBinding
import org.json.JSONObject

class RegistrarCliente : AppCompatActivity() {
    private lateinit var binding: RegistrarClienteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegistrarClienteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.BackBTN.setOnClickListener {
            finish()
        }
        binding.BTNConfirmar.setOnClickListener {
            ConexionBDRegistrarCliente()
        }
    }

    override fun onBackPressed() {
        finish()
    }

    //Conexiones y almacenamiento con la BD
    private fun ConexionBDRegistrarCliente(){
        val Nro_Cedula: String = binding.CIEditText.text.toString()
        val Nombre_Cliente: String = binding.NombreEditText.text.toString()
        val Telefono: String = binding.TelefonoEditText.text.toString()
        val Empresa:String = binding.EmpresaEditText.text.toString()

        //URL de la API en el Servidor
        val url = Constants.SERVER_HOST+"estacionamiento-ita-kua/api/api_registrarCliente.php"

        var requestQueue: RequestQueue = Volley.newRequestQueue(this)
        var stringRequest: StringRequest = object :
            StringRequest(Request.Method.POST,url, Response.Listener { response ->
            val obj = JSONObject(response)

            //Mostrar mensaje de respuesta de la API
            Toast.makeText(applicationContext,obj.getString("message"), Toast.LENGTH_LONG).show()
            if(obj.getString("error").equals("false")){
                limpiar()
            }
        }, Response.ErrorListener { error ->
            Toast.makeText(this,error.message, Toast.LENGTH_LONG).show()
        }){
            override fun getParams(): MutableMap<String, String>? {//Envio de validaciones en la BD
                val parms=HashMap<String,String>()
                parms.put("cedulanro",Nro_Cedula)
                parms.put("nombre_cliente",Nombre_Cliente)
                parms.put("telefono",Telefono)
                parms.put("empresa",Empresa)
                parms.put("usuario_registra",Constants.currentUser.idusuario.toString())
                return parms
            }
        }
        requestQueue.add(stringRequest)
    }

    //Vacia los las escrituras caso se confirme registro del Usuario
    private fun limpiar(){
        binding.CIEditText.setText("")
        binding.EmpresaEditText.setText("")
        binding.NombreEditText.setText("")
        binding.TelefonoEditText.setText("")
    }
}