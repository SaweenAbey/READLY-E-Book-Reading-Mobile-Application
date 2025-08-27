package com.example.readly_ebook

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Editprofile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_editprofile)

        val payValue = findViewById<Button>(R.id.btnSave)
        payValue.setOnClickListener {
            val intent = Intent(this, Settings::class.java)
            startActivity(intent)
    }
        val backText = findViewById<TextView>(R.id.topBar)
        backText.setOnClickListener {
            finish()
        }

    }

}