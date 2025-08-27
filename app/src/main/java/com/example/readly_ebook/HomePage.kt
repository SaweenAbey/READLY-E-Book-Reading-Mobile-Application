package com.example.readly_ebook

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView


class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_page)

        val compassInt = findViewById<ImageView>(R.id.lostCompass)
        compassInt.setOnClickListener {
            val intent1 = Intent(this, LostCompass::class.java)
            startActivity(intent1)
        }

        val lordInt = findViewById<ImageView>(R.id.lordRing)
        lordInt.setOnClickListener {
            val intent2 = Intent(this,Lord::class.java)
            startActivity(intent2)
        }
        val bottom = findViewById<BottomNavigationView>(R.id.bottomNav)


        bottom.selectedItemId = R.id.nav_home

        // Navigate when other tabs are tapped
        bottom.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {true}
                R.id.nav_library -> {
                    startActivity(Intent(this, Library::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.nav_search -> {
                    startActivity(Intent(this, Search::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
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