package com.example.readly_ebook

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity



class CompassReadingView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_compass_reading_view)

        val backText = findViewById<TextView>(R.id.topBar)
        backText.setOnClickListener {
            finish()
        }
    }
}