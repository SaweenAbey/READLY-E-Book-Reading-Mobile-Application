package com.example.readly_ebook

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LostCompass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lost_compass)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.qrpayment)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val backText = findViewById<TextView>(R.id.backbtn1)
        backText.setOnClickListener {
            finish()
        }
        val nextButton = findViewById<TextView>(R.id.startReadingbtn)
        nextButton.setOnClickListener {
            val intent = Intent(this, CompassReadingView::class.java)
            startActivity(intent)

        }
    }
}