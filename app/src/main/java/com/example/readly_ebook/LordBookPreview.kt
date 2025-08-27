package com.example.readly_ebook

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Layer


class LordBookPreview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lord_book_preview)

        val backText: TextView = findViewById(R.id.topBar)
        backText.setOnClickListener{
            finish()
        }
        val purchase = findViewById<Button>(R.id.Purchase1)
        purchase.setOnClickListener {
            startActivity(android.content.Intent(this, Payment::class.java))
        }

    }

}