package com.example.readly_ebook

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Layer
import com.google.android.material.bottomnavigation.BottomNavigationView


class Search : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search)


        val bottom = findViewById<BottomNavigationView>(R.id.bottomNav)

        // Highlight the Library tab on this screen
        bottom.selectedItemId = R.id.nav_search

        // Navigate when other tabs are tapped
        bottom.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, HomePage::class.java))
                    overridePendingTransition(0, 0)
                    true}
                R.id.nav_library -> {
                    startActivity(Intent(this, Library::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.nav_search -> {true}
                R.id.nav_settings -> {
                    startActivity(Intent(this, Settings::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
                else -> false
            }
        }

    }
}