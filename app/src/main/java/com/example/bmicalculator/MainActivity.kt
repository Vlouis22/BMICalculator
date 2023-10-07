package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculateButton = findViewById<TextView>(R.id.button)
        calculateButton.setOnClickListener{
            showResult()
        }
    }
    private fun calculateResult(): Double {
        val heightText = findViewById<EditText>(R.id.in_inches)
        val weightText = findViewById<EditText>(R.id.in_pounds)

        val height = heightText.text.toString().toDouble()
        val weight = weightText.text.toString().toDouble()

        return (weight /(height * height)) * 703
    }

    private fun showResult(){
        val calculation  = calculateResult()

        val calculationText = findViewById<TextView>(R.id.result)
        val resultText = ("%.1f".format(calculation))
        calculationText.text = resultText

        val resultInString = findViewById<TextView>(R.id.resultText)
        if(calculation < 18.5){
            resultInString.text = "Underweight"
        }
        else if(calculation <= 24.9){
            resultInString.text = "Normal Weight"
        }
        else if(calculation <= 29.9){
            resultInString.text = "Overweight"
        }
        else{
            resultInString.text = "Obesity"
        }

    }

}