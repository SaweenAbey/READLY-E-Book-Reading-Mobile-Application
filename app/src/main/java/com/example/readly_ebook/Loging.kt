package com.example.readly_ebook

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class Loging : AppCompatActivity() {

    private lateinit var nameLayout: TextInputLayout
    private lateinit var passwordLayout: TextInputLayout
    private lateinit var etName: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var loginButton: Button
    private lateinit var signupButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_loging)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.qrpayment)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        nameLayout = findViewById(R.id.nameLayout)
        passwordLayout = findViewById(R.id.passwordLayout)
        etName = findViewById(R.id.etName)
        etPassword = findViewById(R.id.etPassword)
        loginButton = findViewById(R.id.btnLogin)
        signupButton = findViewById(R.id.btnSignup)


        loginButton.setOnClickListener {
            if (validateInputs()) {
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
                val intent1 = Intent(this, HomePage::class.java)
                startActivity(intent1)
            }
        }


        signupButton.setOnClickListener {
            val intent = Intent(this, Signup::class.java)
            startActivity(intent)
        }
    }


    private fun validateInputs(): Boolean {
        var isValid = true

        val name = etName.text.toString().trim()
        val password = etPassword.text.toString().trim()


        if (name.isEmpty()) {
            nameLayout.error = "Please enter your name"
            isValid = false
        } else {
            nameLayout.error = null
        }


        if (password.isEmpty()) {
            passwordLayout.error = "Please enter password"
            isValid = false
        } else if (password.length < 6) {
            passwordLayout.error = "Password must be at least 6 characters"
            isValid = false
        } else {
            passwordLayout.error = null
        }

        return isValid
    }
}
