package com.example.readly_ebook

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import java.text.NumberFormat
import java.util.Locale

class Payment : AppCompatActivity() {

    private lateinit var tvCount: TextView
    private lateinit var tvPrice: TextView
    private lateinit var tvAmount: TextView
    private lateinit var btnMinus: ImageButton
    private lateinit var btnPlus: ImageButton
    private lateinit var btnPurchase: MaterialButton
    private lateinit var paymentOptions: RadioGroup

    private var count = 1
    private val pricePerChapter = 200
    private val currency = NumberFormat.getCurrencyInstance(Locale.getDefault())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        tvCount = findViewById(R.id.tvCount)
        tvPrice = findViewById(R.id.tvPrice)
        tvAmount = findViewById(R.id.tvAmount)
        btnMinus = findViewById(R.id.btnMinus)
        btnPlus = findViewById(R.id.btnPlus)
        btnPurchase = findViewById(R.id.btnPurchase)
        paymentOptions = findViewById(R.id.paymentOptions)

        tvPrice.text = currency.format(pricePerChapter)
        updateAmount()

        btnMinus.setOnClickListener {
            if (count > 1) {
                count--
                updateAmount()
            }
        }
        btnPlus.setOnClickListener {
            if (count < 99) {
                count++
                updateAmount()
            }
        }

        btnPurchase.isEnabled = paymentOptions.checkedRadioButtonId != -1
        paymentOptions.setOnCheckedChangeListener { _, _ ->
            btnPurchase.isEnabled = true
        }
        val backText = findViewById<TextView>(R.id.topBar)
        backText.setOnClickListener {
            finish()
        }
    }

    private fun updateAmount() {
        tvCount.text = count.toString()
        val amount = count * pricePerChapter
        tvAmount.text = currency.format(amount)
        btnMinus.isEnabled = count > 1
        btnMinus.alpha = if (btnMinus.isEnabled) 1f else 0.4f
    }

    fun onPurchaseClicked(view: View) {
        when (paymentOptions.checkedRadioButtonId) {
            R.id.qrScan -> startActivity(Intent(this@Payment, QrPayment::class.java))
            R.id.card_Payment -> startActivity(Intent(this@Payment, CardPayment::class.java))
            else -> Toast.makeText(this, "Please select a payment method", Toast.LENGTH_SHORT).show()
        }
    }
}
