package com.example.readly_ebook

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.helper.widget.Layer

class Lord : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lord)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.qrpayment)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val preview = findViewById<Button>(R.id.btnPreview)
        preview.setOnClickListener {
            val intent = Intent(this, LordBookPreview::class.java)
            startActivity(intent)
        }
        val backText: TextView = findViewById(R.id.topBar)
        backText.setOnClickListener {
            finish()
        }
        val purchase = findViewById<Button>(R.id.btnPurchase)
        purchase.setOnClickListener {
            val intent = Intent(this, Payment::class.java)
            startActivity(intent)
        }


    }
}