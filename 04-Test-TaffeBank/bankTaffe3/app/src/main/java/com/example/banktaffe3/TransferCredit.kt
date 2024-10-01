package com.example.banktaffe3
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.banktaffe3.R.*


class TransferCredit : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.tranfercredit)

        val calculo = findViewById<TextView>(R.id.transacao)
        val description = findViewById<TextView>(R.id.description)
        val voltar = findViewById<TextView>(R.id.back);
        var valor = findViewById<EditText>(R.id.valor);
        var result = findViewById<TextView>(R.id.result);

        val total = findViewById<TextView>(R.id.total);
        var money: Double = 200.0


        total.setText("TOTAL: R$ $money")

        calculo.setOnClickListener {
            money -= valor.text.toString().toDouble()

            total.setText("TOTAL: R$ $money");
            result.setText("${result.text.toString()}\n" + "Valor: ${valor.text.toString()} | Descrição: ${description.text.toString()}\n");
        }

        voltar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

