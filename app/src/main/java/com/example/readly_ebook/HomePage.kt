package com.example.readly_ebook

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_page)

        val compassInt = findViewById<Button>(R.id.compass)

        compassInt.setOnClickListener {
            val intent1 = Intent(this, LostCompass::class.java)
            startActivity(intent1)
        }
    }
}