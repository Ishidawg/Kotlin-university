package com.example.calculadoradeimc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heightInput = findViewById<EditText>(R.id.height_input)
        val weightInput = findViewById<EditText>(R.id.weight_input)
        val calculateButton = findViewById<Button>(R.id.calculate_button)
        val resultText = findViewById<TextView>(R.id.result_text)

        calculateButton.setOnClickListener {
            val height = heightInput.text.toString().toDoubleOrNull()
            val weight = weightInput.text.toString().toDoubleOrNull()

            if (height != null && weight != null) {
                val imc = weight / (height * height)
                resultText.text = when {
                    imc < 18.5 -> "Abaixo do peso (IMC: %.2f)".format(imc)
                    imc in 18.5..24.9 -> "Peso normal (IMC: %.2f)".format(imc)
                    imc in 25.0..29.9 -> "Sobrepeso (IMC: %.2f)".format(imc)
                    else -> "Obesidade (IMC: %.2f)".format(imc)
                }
            } else {
                resultText.text = "Por favor, insira valores válidos."
            }
        }
    }
}
