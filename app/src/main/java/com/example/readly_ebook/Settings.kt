package com.example.readly_ebook

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class Settings : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_settings)


        findViewById<TextView>(R.id.topBar).setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }


        val bottom = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottom.selectedItemId = R.id.nav_settings
        bottom.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, HomePage::class.java)); overridePendingTransition(0, 0); true
                }
                R.id.nav_library -> {
                    startActivity(Intent(this, Library::class.java)); overridePendingTransition(0, 0); true
                }
                R.id.nav_search -> {
                    startActivity(Intent(this, Search::class.java)); overridePendingTransition(0, 0); true
                }
                R.id.nav_settings -> true
                else -> false
            }
        }


        val btnLogout = findViewById<MaterialButton>(R.id.btnLogout)
        btnLogout.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Log out?")
                .setMessage("You’ll need to sign in again to access your library.")
                .setNegativeButton("Cancel", null)
                .setPositiveButton("Log out") { _, _ ->

                    val intent = Intent(this, Loging::class.java).apply {

                        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    }
                    startActivity(intent)
                    Toast.makeText(this, "You have been logged out", Toast.LENGTH_SHORT).show()
                }
                .show()
        }

        val editpro = findViewById<MaterialButton>(R.id.btnEdit)
        editpro.setOnClickListener {
            startActivity(Intent(this, Editprofile::class.java))
        }

    }
}
