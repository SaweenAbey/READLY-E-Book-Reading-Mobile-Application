package com.example.readly_ebook

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class CompassReadingView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_compass_reading_view)

        val addButton: ImageButton = findViewById(R.id.imageButton1)
        val toast = Toast.makeText(this, "Book added to your library 📚", Toast.LENGTH_SHORT)
        toast.show()

        val backText = findViewById<TextView>(R.id.back27)
        backText.setOnClickListener {
            finish()
        }
    }
}