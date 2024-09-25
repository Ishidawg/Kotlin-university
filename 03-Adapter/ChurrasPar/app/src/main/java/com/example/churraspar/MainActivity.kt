package com.example.churraspar

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var menInput: EditText
    private lateinit var womenInput: EditText
    private lateinit var childrenInput: EditText
    private lateinit var calculateButton: Button
    private lateinit var clearButton: Button
    private lateinit var resultText: TextView
    private lateinit var meatText: TextView
    private lateinit var snacksText: TextView
    private lateinit var totalFoodText: TextView
    private lateinit var beerText: TextView
    private lateinit var waterText: TextView
    private lateinit var sodaText: TextView
    private lateinit var totalDrinksText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.title)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        menInput = findViewById(R.id.men_input)
        womenInput = findViewById(R.id.women_input)
        childrenInput = findViewById(R.id.children_input)
        calculateButton = findViewById(R.id.calculate_button)
        clearButton = findViewById(R.id.clear_button)
        resultText = findViewById(R.id.calculation_info)
        meatText = findViewById(R.id.meat_value)
        snacksText = findViewById(R.id.snacks_value)
        totalFoodText = findViewById(R.id.total_food_value)
        beerText = findViewById(R.id.beer_value)
        waterText = findViewById(R.id.water_value)
        sodaText = findViewById(R.id.soda_value)
        totalDrinksText = findViewById(R.id.total_drinks_value)

        calculateButton.setOnClickListener {
            calculateBarbecue()
        }

        clearButton.setOnClickListener {
            clearInputs()
        }
    }

    // WOW so much math in here!!
    private fun calculateBarbecue() {
        val men = menInput.text.toString().toIntOrNull() ?: 0
        val women = womenInput.text.toString().toIntOrNull() ?: 0
        val children = childrenInput.text.toString().toIntOrNull() ?: 0

        val totalParticipants = men + women + children

        val meat = (men * 400 + women * 300 + children * 200) * 1.1
        meatText.text = "${meat.toInt()}g Carne"

        val snacks = (men * 150 + women * 100 + children * 50) * 1.1
        snacksText.text = "${snacks.toInt()}g Aperitivos"

        totalFoodText.text = "${(meat + snacks).toInt()}g TOTAL"

        val beer = (men * 4 + women * 2) * 1.1
        beerText.text = "${beer.toInt()}L Cerveja"

        val water = (women * 2 + children * 2) * 1.1
        waterText.text = "${water.toInt()}L Água"

        val soda = (women * 1.5 + children * 1.5) * 1.1
        sodaText.text = "${soda.toInt()}L Refrigerante"

        totalDrinksText.text = "${(beer + water + soda).toInt()} Litros TOTAL"

        resultText.text = "Realizamos o cálculo para $totalParticipants participantes"
    }

    private fun clearInputs() {
        menInput.setText("0")
        womenInput.setText("0")
        childrenInput.setText("0")
        resultText.text = ""
        meatText.text = "0g Carne"
        snacksText.text = "0g Aperitivos"
        totalFoodText.text = "0g TOTAL"
        beerText.text = "0L Cerveja"
        waterText.text = "0L Água"
        sodaText.text = "0L Refrigerante"
        totalDrinksText.text = "0 Litros TOTAL"
    }
}