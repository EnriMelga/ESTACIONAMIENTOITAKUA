package com.dme.itakua

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.dme.itakua.databinding.ActivityPantallaInicioBinding

class PantallaInicio : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityPantallaInicioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPantallaInicioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarPantallaInicio.toolbar)


        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_pantalla_inicio)


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_precio_tarifa, R.id.nav_informe,R.id.configuracionFragment
                ,R.id.salidaFragment
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.pantalla_inicio, menu)
        return true
    }

    //Logica al pulsar menu superior derecho
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id:Int = item.itemId

        if(id == R.id.Btn_Cerrar_Sesion){
            //Pulsa cambiar de Usuario
            AlertDialog.Builder(this@PantallaInicio)
                .setMessage("¿Cerrar Sesion?")
                .setCancelable(false)
                .setPositiveButton("Si") { dialog, whichButton ->
                    //Vuelve a pantalla de Iniciar Sesion
                    startActivity(Intent(this,IniciarSesion::class.java))
                    finish()
                }
                .setNegativeButton("Cancelar") { dialog, whichButton ->
                }
                .show()
            return true
        }
    return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_pantalla_inicio)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    //Dialogo de confirmacion de salida en el Menu prinicipal
    override fun onBackPressed() {//Pulsa a volver atras en el cualquier fragment
        AlertDialog.Builder(this@PantallaInicio)
            .setMessage("¿Estas seguro que desea salir?")
            .setCancelable(false)
            .setPositiveButton("Si") { dialog, whichButton ->
                finishAffinity() //Sale de la app
            }
            .setNegativeButton("Cancelar") { dialog, whichButton ->

            }
            .show()
    }
}