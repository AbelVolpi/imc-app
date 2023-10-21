package com.example.imcapp

import android.app.Activity
import android.os.Bundle
import android.widget.TextView


class ImcActivity : Activity() {

    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var textViewName: TextView
    private lateinit var textViewWeight: TextView
    private lateinit var textViewHeight: TextView
    private lateinit var textViewImc: TextView
    private lateinit var textViewResult: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)
        toolbar = findViewById(R.id.toolbar)
        textViewName = findViewById(R.id.text_view_name)
        textViewWeight = findViewById(R.id.text_view_weight)
        textViewHeight = findViewById(R.id.text_view_height)
        textViewImc = findViewById(R.id.text_view_imc)
        textViewResult = findViewById(R.id.text_view_result)

        val imc = intent.getSerializableExtra("imc").toString().toFloat()
        val roundedImc = String.format("%.1f", imc).toFloat()

        textViewName.text = intent.getSerializableExtra("name").toString()
        textViewWeight.text = intent.getSerializableExtra("weight").toString()
        textViewHeight.text = intent.getSerializableExtra("height").toString()
        textViewImc.text = roundedImc.toString()

        textViewResult.text = when {
            roundedImc <= 18.5 -> {
                "abaixo do peso"
            }
            roundedImc in 18.6..24.9 -> {
                "Peso ideal (parabéns)"
            }
            roundedImc in 25.0..29.9 -> {
                "Levemente acima do peso"
            }
            roundedImc in 30.0..34.9 -> {
                "Obesidade grau I"
            }
            roundedImc in 35.0..39.9 -> {
                "Obesidade grau II (severa)"
            }
            roundedImc >= 40 -> {
                "Obesidade grau III (mórbida)"
            }
            else -> {
                ""
            }
        }

        toolbar.setNavigationOnClickListener {
            this.onBackPressed()
        }
    }
}