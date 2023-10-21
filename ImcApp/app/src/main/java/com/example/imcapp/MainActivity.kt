package com.example.imcapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlin.math.pow

class MainActivity : Activity() {

    private lateinit var editTextName: EditText
    private lateinit var editTextWeight: EditText
    private lateinit var editTextHeight: EditText
    private lateinit var buttonCalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextName = findViewById(R.id.edit_text_name)
        editTextWeight = findViewById(R.id.edit_text_weight)
        editTextHeight = findViewById(R.id.edit_text_height)
        buttonCalculate = findViewById(R.id.button_calculate)

        buttonCalculate.setOnClickListener {
            if (verifyFields()) {
                changeActivity()
            } else {
                Toast.makeText(this, "Some of the field are empty", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun verifyFields(): Boolean {
        when {
            editTextName.text.isEmpty()-> {
                return false
            }
            editTextWeight.text.isEmpty() -> {
                return false
            }
            editTextHeight.text.isEmpty() -> {
                return false
            }
        }
        return true
    }

    private fun changeActivity() {
        val intent = Intent(this, ImcActivity::class.java).apply {
            putExtra("name", editTextName.text.toString())
            putExtra("weight", editTextWeight.text.toString())
            putExtra("height", editTextHeight.text.toString())
            putExtra("imc", calculateIMC())
        }
        startActivity(intent)
    }

    private fun calculateIMC(): Float {
        val weight = editTextWeight.text.toString().toFloat()
        val height = editTextHeight.text.toString().toFloat()
        return weight / height.pow(2)
    }

}