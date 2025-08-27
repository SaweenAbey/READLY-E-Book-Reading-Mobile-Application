package com.example.readly_ebook

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.text.method.DigitsKeyListener
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class CardPayment : AppCompatActivity() {

    private lateinit var etCardNumber: EditText
    private lateinit var etMonth: EditText
    private lateinit var etYear: EditText
    private lateinit var etCvv: EditText
    private lateinit var btnPay: Button
    private lateinit var btnBack: TextView
    private lateinit var cbSave: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_card_payment)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        etCardNumber = findViewById(R.id.editTextNumberDecimal)
        etMonth = findViewById(R.id.editTextNumberDecimal2)
        etYear = findViewById(R.id.editTextNumberDecimal3)
        etCvv = findViewById(R.id.editTextNumberDecimal4)
        btnPay = findViewById(R.id.paybutton)
        btnBack = findViewById(R.id.topBar)
        cbSave = findViewById(R.id.checkBox)


        btnPay.setOnClickListener {
            if (validateCardForm()) {
                Toast.makeText(this, "Book added to your library 📚", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, PaymentDone::class.java))
            }
        }

        btnBack.setOnClickListener { finish() }
    }

    private fun validateCardForm(): Boolean {
        var ok = true

        val numberRaw = etCardNumber.text?.toString().orEmpty()
        val number = numberRaw.replace(" ", "").trim()

        val monthStr = etMonth.text?.toString()?.trim().orEmpty()
        val yearStr = etYear.text?.toString()?.trim().orEmpty()
        val cvv = etCvv.text?.toString()?.trim().orEmpty()

        // CARD NUMBER
        if (number.length !in 13..19) {
            etCardNumber.error = "Card number must be 13–19 digits"
            ok = false
        } else if (!number.all { it.isDigit() }) {
            etCardNumber.error = "Card number must contain only digits"
            ok = false
        } else {
            etCardNumber.error = null
        }


        val month = monthStr.toIntOrNull()
        if (month == null || month !in 1..12) {
            etMonth.error = "Invalid month (01–12)"
            ok = false
        } else {
            etMonth.error = null
        }


        val yearNormalized: Int? = when (yearStr.length) {
            2 -> {
                val yy = yearStr.toIntOrNull()
                if (yy == null) null else 2000 + yy
            }
            4 -> yearStr.toIntOrNull()
            else -> null
        }

        if (yearNormalized == null || yearNormalized < 2000 || yearNormalized > 2099) {
            etYear.error = "Invalid year"
            ok = false
        } else {
            etYear.error = null
        }


        if (ok) {
            val now = Calendar.getInstance()
            val currentYear = now.get(Calendar.YEAR)
            val currentMonth = now.get(Calendar.MONTH) + 1

            if (yearNormalized!! < currentYear ||
                (yearNormalized == currentYear && month!! < currentMonth)
            ) {
                etMonth.error = "Card expired"
                etYear.error = "Card expired"
                ok = false
            }
        }


        if (cvv.length !in 3..4 || !cvv.all { it.isDigit() }) {
            etCvv.error = "CVV must be 3–4 digits"
            ok = false
        } else {
            etCvv.error = null
        }

        return ok
    }
    private fun addClearErrorOnChange(et: EditText) {
        et.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                et.error = null
            }
            override fun afterTextChanged(s: Editable?) {}
        })
    }
}
