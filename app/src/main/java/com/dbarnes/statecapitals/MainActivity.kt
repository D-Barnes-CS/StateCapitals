package com.dbarnes.statecapitals

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dbarnes.statecapitals.databinding.ActivityMainBinding
import android.util.Log
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: CapitalViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        displayRandomStateCapital()

        binding.nextButton.setOnClickListener {
            displayRandomStateCapital()
        }
    }

    private fun displayRandomStateCapital() {
        val randomCapital = viewModel.getRandomStateCapital()
        var messageString = "${randomCapital.capitalCity} " +
                "is the capital of ${randomCapital.state}"
        binding.capitalInfo.text = messageString
    }
}