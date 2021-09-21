package com.example.calculatorexample
import android.widget.Button
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import android.widget.Toast
import com.example.calculatorexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var firstValue: Double = 0.0
    var operator: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Jetpack view binding
        //Initialize binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        //Vamos a usar binding + id del botton
       binding.btnDelete.setOnClickListener{
           binding.etCalculations.setText(binding.etCalculations.text.dropLast(1))
       }
       binding.btnClear.setOnClickListener{
           binding.etCalculations.text.clear()
       }
       binding.btnEqual.setOnClickListener{
           when(operator){
               "Minus" -> {
                   binding.etCalculations.setText("${firstValue - binding.etCalculations.text.toString().toDouble()}")
               }
               "Plusss" -> {
                   binding.etCalculations.setText("${firstValue + binding.etCalculations.text.toString().toDouble()}")
               }
               "Multiplication" -> {
                   binding.etCalculations.setText("${firstValue * binding.etCalculations.text.toString().toDouble()}")
               }
               "Disviion" -> {
                   binding.etCalculations.setText("${firstValue / binding.etCalculations.text.toString().toDouble()}")
               }
               "Percentage" -> {
                   binding.etCalculations.setText("${firstValue % binding.etCalculations.text.toString().toDouble()}")
               }
               else -> { }
           }
       }
    }

    fun numberButton(view: View) {
        val button = view as Button
        binding.etCalculations.text.append(button.text)
        when(button.id){
            binding.btnDot.id -> { binding.etCalculations.text.append(".") }
        }
    }
    fun operatorClicked (view: View) {
        val button = view as Button
        operator = when(button.id){
            // binding.btnDot.id -> { binding.etCalculations.text.append(".")}
            binding.btnMinus.id -> {"Minus"}
            binding.btnPluss.id -> { "Plusss"}
            binding.btnMult.id -> { "Multiplication"}
            binding.btnDiv.id -> { "Division"}
            binding.btnPer.id -> { "Percentage"}
            else -> { "" }
        }

        firstValue = binding.etCalculations.text.toString().toDouble()
        binding.etCalculations.text.clear()
    }

}

