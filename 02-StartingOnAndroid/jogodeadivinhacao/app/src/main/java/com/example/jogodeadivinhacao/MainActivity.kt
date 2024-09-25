package com.example.jogodeadivinhacao

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var randomNumber = Random.nextInt(1, 101)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guessInput = findViewById<EditText>(R.id.guess_input)
        val checkButton = findViewById<Button>(R.id.check_button)
        val hintText = findViewById<TextView>(R.id.hint_text)

        checkButton.setOnClickListener {
            val guess = guessInput.text.toString().toIntOrNull()

            if (guess != null) {
                when {
                    guess < randomNumber -> hintText.text = "Seu palpite é muito baixo."
                    guess > randomNumber -> hintText.text = "Seu palpite é muito alto."
                    else -> hintText.text = "Parabéns! Você acertou."
                }
            } else {
                hintText.text = "Por favor, insira um número válido."
            }
        }
    }
}
