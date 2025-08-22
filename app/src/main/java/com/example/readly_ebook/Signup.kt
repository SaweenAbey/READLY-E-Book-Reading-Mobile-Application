package com.example.readly_ebook

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        val nextButton = findViewById<Button>(R.id.btnSignUp)

        nextButton.setOnClickListener {
            val intent = Intent(this, Loging::class.java)
            startActivity(intent)
        }

    }
}