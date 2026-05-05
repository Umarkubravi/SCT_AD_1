package com.example.calculatorapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private var currentInput = ""
    private var operator = ""
    private var firstNumber = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.tvResult)
    }

    fun onNumberClick(view: View) {
        val button = view as Button
        currentInput += button.text.toString()
        tvResult.text = currentInput
    }

    fun onOperatorClick(view: View) {
        val button = view as Button
        operator = button.text.toString()
        firstNumber = currentInput.toDoubleOrNull() ?: 0.0
        currentInput = ""
    }

    fun onEqualClick(view: View) {
        val secondNumber = currentInput.toDoubleOrNull() ?: 0.0
        var result = 0.0

        when (operator) {
            "+" -> result = firstNumber + secondNumber
            "-" -> result = firstNumber - secondNumber
            "*" -> result = firstNumber * secondNumber
            "/" -> result = if (secondNumber != 0.0) firstNumber / secondNumber else 0.0
        }

        tvResult.text = result.toString()
        currentInput = result.toString()
    }

    fun onClearClick(view: View) {
        currentInput = ""
        operator = ""
        firstNumber = 0.0
        tvResult.text = "0"
    }
}