package com.example.conversordemoedas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val amountInput = findViewById<EditText>(R.id.amount_input)
        val conversionRateInput = findViewById<EditText>(R.id.conversion_rate_input)
        val convertButton = findViewById<Button>(R.id.convert_button)
        val resultText = findViewById<TextView>(R.id.result_text)

        convertButton.setOnClickListener {
            val amount = amountInput.text.toString().toDoubleOrNull()
            val conversionRate = conversionRateInput.text.toString().toDoubleOrNull()

            if (amount != null && conversionRate != null) {
                val convertedValue = amount * conversionRate
                resultText.text = "Valor convertido: $convertedValue"
            } else {
                resultText.text = "Por favor, insira valores válidos."
            }
        }
    }
}
