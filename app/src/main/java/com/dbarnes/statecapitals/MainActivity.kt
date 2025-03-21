package com.dbarnes.statecapitals

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dbarnes.statecapitals.databinding.ActivityMainBinding
import android.util.Log
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var stateList: ArrayList<Capital>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val rawDataArray = resources.getStringArray(R.array.states)
        var stateName: String
        var capitolName: String
        var stringArray: List<String>
        var capital: Capital
        stateList = ArrayList<Capital>()

        for (state in rawDataArray) {
            stringArray = state.split(",")
            stateName = stringArray[0]
            capitolName = stringArray[1]
            //create instance of Capital
            capital = Capital(stateName, capitolName)
            stateList.add(capital)
        }
        var capitalObject = stateList.get(Random.nextInt(stateList.size))
        var messageString = "${capitalObject.capitalCity} " +
                "is the capital of ${capitalObject.state}"
        binding.capitalInfo.setText(messageString)

        binding.nextButton.setOnClickListener {
            capitalObject = stateList.get(Random.nextInt(stateList.size))
            messageString = "${capitalObject.capitalCity} " +
                    "is the capital of ${capitalObject.state}"
            binding.capitalInfo.setText(messageString)
        }
    }
}