package com.example.currencyconverter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rub1 = findViewById<Button>(R.id.rub1)
        val rub2 = findViewById<Button>(R.id.rub2)
        val usd1 = findViewById<Button>(R.id.usd1)
        val usd2 = findViewById<Button>(R.id.usd2)
        val eur1 = findViewById<Button>(R.id.eur1)
        val eur2 = findViewById<Button>(R.id.eur2)
        val jpy1 = findViewById<Button>(R.id.jpy1)
        val jpy2 = findViewById<Button>(R.id.jpy2)
        val update = findViewById<Button>(R.id.Update)

        val textView = findViewById<TextView>(R.id.textView)
        val textView2 = findViewById<TextView>(R.id.textView2)
        val winx = findViewById<TextView>(R.id.winx)
        val inputText = findViewById<EditText>(R.id.inputText)

        var from = "rub"
        var to = "usd"
        var output = 0.0
        var multyply = 1.0

        rub1.setOnClickListener {
            from = "rub"
            textView.text = "Рубль"
            when (to) {
                "usd" -> multyply = 1.0 / 74
                "rub" -> multyply = 1.0
                "eur" -> multyply = 1.0/ 78
                "jpy" -> multyply = 1.57
            }
        }

        usd1.setOnClickListener {
            from = "usd"
            textView.text = "Доллар"
            when (to) {
                "usd" -> multyply = 1.0
                "rub" -> multyply = 74.0
                "eur" -> multyply = 0.88
                "jpy" -> multyply = 107.95
            }
        }
        eur1.setOnClickListener {
            from = "eur"
            textView.text = "Евро"
            when (to) {
                "usd" -> multyply = 1 / 0.88
                "rub" -> multyply = 78.0
                "eur" -> multyply = 1.0
                "jpy" -> multyply = 121.58
            }
        }
        jpy1.setOnClickListener {
            from = "jpy"
            textView.text = "Йена"
            when (to) {
                "jpy" -> multyply = 1.0
                "rub" -> multyply = 0.64
                "eur" -> multyply = 0.0082
                "usd" -> multyply = 0.0093
            }
        }

        rub2.setOnClickListener {
            to = "rub"
            textView2.text = "Рубль"
            when (from) {
                "jpy" -> multyply = 0.64
                "rub" -> multyply = 1.0
                "eur" -> multyply = 78.0
                "usd" -> multyply = 74.0
            }
        }

        usd2.setOnClickListener {
            to = "usd"
            textView2.text = "Доллар"
            when (from) {
                "jpy" -> multyply = 0.0093
                "rub" -> multyply = 1.0 / 74
                "eur" -> multyply = 1 / 0.88
                "usd" -> multyply = 1.0
            }
        }

        eur2.setOnClickListener {
            to = "eur"
            textView2.text = "Евро"
            when (from) {
                "jpy" -> multyply = 0.0082
                "rub" -> multyply = 1.0 / 78
                "eur" -> multyply = 1.0
                "usd" -> multyply = 1.0 / 0.88
            }
        }
        jpy2.setOnClickListener {
            to = "jpy"
            textView2.text = "Йена"
            when (from) {
                "jpy" -> multyply = 1.0
                "rub" -> multyply = 1.57
                "eur" -> multyply = 121.58
                "usd" -> multyply = 107.95
            }
        }

        update.setOnClickListener {
            val input = inputText.text.toString().toDouble()
            output = multyply * input
            output = "%.2f".format(output).toDouble()
            winx.text = output.toString()
        }
    }
}