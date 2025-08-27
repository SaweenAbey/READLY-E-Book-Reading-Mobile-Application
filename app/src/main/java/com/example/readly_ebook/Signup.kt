package com.example.readly_ebook

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class Signup : AppCompatActivity() {

    private lateinit var tilName: TextInputLayout
    private lateinit var tilEmail: TextInputLayout
    private lateinit var tilPassword: TextInputLayout
    private lateinit var tilConfirm: TextInputLayout

    private lateinit var etName: TextInputEditText
    private lateinit var etEmail: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var etConfirm: TextInputEditText

    private lateinit var cbTerms: CheckBox
    private lateinit var btnSignUp: MaterialButton
    private lateinit var tvGoToLogin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.qrpayment)) { v, insets ->
            val sb = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(sb.left, sb.top, sb.right, sb.bottom)
            insets
        }


        tilName = findViewById(R.id.tilName)
        tilEmail = findViewById(R.id.tilEmail)
        tilPassword = findViewById(R.id.tilPassword)
        tilConfirm = findViewById(R.id.tilConfirm)

        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        etConfirm = findViewById(R.id.etConfirm)

        cbTerms = findViewById(R.id.cbTerms)
        btnSignUp = findViewById(R.id.btnSignUp)
        tvGoToLogin = findViewById(R.id.tvGoToLogin)


        etName.addTextChangedListener { tilName.error = null }
        etEmail.addTextChangedListener { tilEmail.error = null }
        etPassword.addTextChangedListener { tilPassword.error = null; tilConfirm.error = null }
        etConfirm.addTextChangedListener { tilConfirm.error = null }

        btnSignUp.setOnClickListener {
            if (validate()) {
                Toast.makeText(this, "Account created!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, Loging::class.java))
                finish()
            }
        }

        tvGoToLogin.setOnClickListener {
            startActivity(Intent(this, Loging::class.java))
            finish()
        }
    }

    private fun validate(): Boolean {
        var ok = true

        val name = etName.text?.toString()?.trim().orEmpty()
        val email = etEmail.text?.toString()?.trim().orEmpty()
        val pass = etPassword.text?.toString().orEmpty()
        val confirm = etConfirm.text?.toString().orEmpty()

        if (name.length < 2) {
            tilName.error = "Please enter your full name"
            ok = false
        }

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            tilEmail.error = "Enter a valid email address"
            ok = false
        }

        if (pass.length < 6) {
            tilPassword.error = "Password must be at least 6 characters"
            ok = false
        }

        if (confirm != pass) {
            tilConfirm.error = "Passwords do not match"
            ok = false
        }

        if (!cbTerms.isChecked) {
            Toast.makeText(this, "Please accept Terms & Privacy Policy", Toast.LENGTH_SHORT).show()
            ok = false
        }

        return ok
    }
}
