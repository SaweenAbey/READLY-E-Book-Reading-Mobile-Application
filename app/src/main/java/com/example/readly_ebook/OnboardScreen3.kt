package com.example.readly_ebook

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class OnboardScreen3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_onboard_screen3)

        val nextButton = findViewById<Button>(R.id.Onbord3)

        nextButton.setOnClickListener {
            val intent = Intent(this, Loging::class.java)
            startActivity(intent)
        }
    }
}