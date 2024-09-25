package com.example.verificadordeidade

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ageInput = findViewById<EditText>(R.id.age_input)
        val verifyButton = findViewById<Button>(R.id.verify_button)
        val resultText = findViewById<TextView>(R.id.result_text)

        verifyButton.setOnClickListener {
            val age = ageInput.text.toString().toIntOrNull()

            age?.let {
                when {
                    it < 18 -> resultText.text = "Você é menor de idade."
                    it in 18..60 -> resultText.text = "Você está na meia idade."
                    else -> resultText.text = "Você é idoso."
                }
            } ?: run {
                resultText.text = "Por favor, insira uma idade válida."
            }
        }
    }
}
