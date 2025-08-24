package com.example.readly_ebook

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class LordBookPreview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lord_book_preview)

        val backText: TextView = findViewById(R.id.bckBtn)
        backText.setOnClickListener { finish() }
    }

}