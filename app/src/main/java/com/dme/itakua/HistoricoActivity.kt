package com.dme.itakua

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dme.itakua.databinding.ActivityHistoricoBinding
import com.dme.itakua.databinding.ArqueoDeCajaBinding

class HistoricoActivity : AppCompatActivity(){
    private lateinit var binding: ActivityHistoricoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoricoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.BackBTN.setOnClickListener {
            finish()
        }
    }
}