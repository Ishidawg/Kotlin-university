package com.example.verificadordesenha

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val correctPassword = "1234"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val passwordInput = findViewById<EditText>(R.id.passwordinput)
        val verifyButton = findViewById<Button>(R.id.verifybutton)
        val resultText = findViewById<TextView>(R.id.resulttext)

        verifyButton.setOnClickListener {
            val password = passwordInput.text.toString()
            if (password == correctPassword) {
                resultText.text = "Senha correta"
            } else {
                resultText.text = "Senha incorreta"
            }
        }
    }
}
