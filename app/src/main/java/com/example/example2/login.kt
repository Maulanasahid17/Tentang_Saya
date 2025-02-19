package com.example.example2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import android.content.Intent
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class login : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
//        val nama = findViewById<EditText>(R.id.editTextText)
//        val pass = findViewById<EditText>(R.id.editTextTextPassword)
//
//        val buttonClick = findViewById<Button>(R.id.ButtonLogin)
//        buttonClick.setOnClickListener {
//            if (nama.text.toString()=="user" && pass.text.toString()=="123") {
//                val intent = Intent(this, MainActivity::class.java)
//                Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show()
//
//                startActivity(intent)
//            } else {
//                Toast.makeText(this, "Login Failed!", Toast.LENGTH_SHORT).show()
//            }
//
//        }

        val dbHelper = DatabaseHelper(this)

        // 🔥 Cek apakah ada user di database
        if (!dbHelper.isUserExists()) {
            startActivity(Intent(this, Register::class.java))
            finish() // Tutup LoginActivity agar tidak bisa kembali ke sini
            return
        }

        val usernameEditText = findViewById<EditText>(R.id.editTextText)
        val passwordEditText = findViewById<EditText>(R.id.editTextTextPassword)
        val loginButton = findViewById<Button>(R.id.ButtonLogin)
        val registerButton = findViewById<TextView>(R.id.buttonRegis)

        loginButton.setOnClickListener {

            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (dbHelper.checkUser(username, password)) {
                Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                Toast.makeText(this, "Username atau password salah!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}