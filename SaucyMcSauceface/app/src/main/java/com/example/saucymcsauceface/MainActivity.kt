package com.example.saucymcsauceface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.saucymcsauceface.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sauceViewModel: SauceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sauceViewModel = ViewModelProvider(this).get(SauceViewModel::class.java)
        binding.newTaskButton.setOnClickListener {
            NewSauceFragment(null).show(supportFragmentManager, "NewSauceTag")
        }
    }
}