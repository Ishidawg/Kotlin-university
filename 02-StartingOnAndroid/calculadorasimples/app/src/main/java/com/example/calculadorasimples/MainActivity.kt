package com.example.calculadorasimples

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number1Input = findViewById<EditText>(R.id.number1_input)
        val number2Input = findViewById<EditText>(R.id.number2_input)
        val sumButton = findViewById<Button>(R.id.sum_button)
        val subtractButton = findViewById<Button>(R.id.subtract_button)
        val resultText = findViewById<TextView>(R.id.result_text)

        sumButton.setOnClickListener {
            val num1 = number1Input.text.toString().toDoubleOrNull()
            val num2 = number2Input.text.toString().toDoubleOrNull()

            if (num1 != null && num2 != null) {
                resultText.text = "Resultado: ${num1 + num2}"
            } else {
                resultText.text = "Por favor, insira números válidos."
            }
        }

        subtractButton.setOnClickListener {
            val num1 = number1Input.text.toString().toDoubleOrNull()
            val num2 = number2Input.text.toString().toDoubleOrNull()

            if (num1 != null && num2 != null) {
                resultText.text = "Resultado: ${num1 - num2}"
            } else {
                resultText.text = "Por favor, insira números válidos."
            }
        }
    }
}
