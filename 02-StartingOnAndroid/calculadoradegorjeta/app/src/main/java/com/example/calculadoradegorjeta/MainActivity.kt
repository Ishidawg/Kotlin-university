package com.example.calculadoradegorjeta

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val billAmountInput = findViewById<EditText>(R.id.bill_amount_input)
        val tipPercentageInput = findViewById<EditText>(R.id.tip_percentage_input)
        val calculateTipButton = findViewById<Button>(R.id.calculate_tip_button)
        val resultText = findViewById<TextView>(R.id.result_text)

        calculateTipButton.setOnClickListener {
            val billAmount = billAmountInput.text.toString().toDoubleOrNull()
            val tipPercentage = tipPercentageInput.text.toString().toDoubleOrNull()

            if (billAmount != null && tipPercentage != null) {
                val tip = billAmount * (tipPercentage / 100)
                val total = billAmount + tip
                resultText.text = "Gorjeta: R$%.2f, Total: R$%.2f".format(tip, total)
            } else {
                resultText.text = "Por favor, insira valores válidos."
            }
        }
    }
}
