package com.example.banktaffe3

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val credito = findViewById<TextView>(R.id.credito);
        val debito = findViewById<TextView>(R.id.debito);
        val total = findViewById<TextView>(R.id.total);

        var money: Double = 200.0

        total.setText("TOTAL: R$ $money")

        credito.setOnClickListener {
            val intent = Intent(this, TransferCredit::class.java)
            startActivity(intent)
        }

        debito.setOnClickListener {
            val intent = Intent(this, TransferDebit::class.java)
            startActivity(intent)
        }

    }

    companion object
}