package com.dme.itakua

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dme.itakua.databinding.ArqueoDeCajaBinding

class ArqueodeCaja : AppCompatActivity(){
    private lateinit var binding: ArqueoDeCajaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ArqueoDeCajaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.BackBTN.setOnClickListener {
            finish()
        }
    }
}