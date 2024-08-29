package com.example.clickcounter

import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val myButton = findViewById<TextView>(R.id.clickbtn);
        var myResult = findViewById<TextView>(R.id.result);
        var myBonus = findViewById<TextView>(R.id.bonus);
        var myImage = findViewById<ImageView>(R.id.memeImage);

        val bonuses = arrayOf("STOP!", "DAMN BOY, STOP!!", "YOU'LL BREAKE YOUR SCREEN!!", "JESUS!!");

        var count = 0

        fun randomBonuses() {
            val randomValues = List(3) { Random.nextInt(bonuses.size) };
            val randomIndex = randomValues.random();
            myBonus.setText(bonuses[randomIndex]);
        }

        fun checkBunus() {
            if (count <= 19) {
                myBonus.setText("");
            } else if (count <= 20) {
                myBonus.setText("Wow, you've clicked $count times..");
            } else if (count >= 21 && count < 50) {
                myBonus.setText("Wow, you've clicked $count times!#@%$#!!");
            } else {
                randomBonuses()
                myImage.setImageResource(R.drawable.imagememe)
            }
        }

        myButton.setOnClickListener{
            myResult.setText(count.toString());
            count += 1;

            checkBunus();
        }
    }
}