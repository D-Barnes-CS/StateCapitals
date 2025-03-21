package com.dbarnes.statecapitals

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dbarnes.statecapitals.databinding.ActivityMainBinding
import androidx.activity.viewModels


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel: CapitalViewModel by viewModels()
        displayRandomStateCapital()

        binding.nextButton.setOnClickListener {
            displayRandomStateCapital()
        }
    }

    private fun displayRandomStateCapital() {
        val randomCapital = viewModel.getRandomStateCapital()
        val messageString = "${randomCapital.capitalCity} " +
                "is the capital of ${randomCapital.state}"
        binding.capitalInfo.text = messageString
    }
}