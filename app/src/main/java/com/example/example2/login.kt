package com.example.example2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        val nama = findViewById<EditText>(R.id.editTextText)
        val pass = findViewById<EditText>(R.id.editTextTextPassword)

        val buttonClick = findViewById<Button>(R.id.ButtonLogin)
        buttonClick.setOnClickListener {
            if (nama.text.toString()=="user" && pass.text.toString()=="123") {
                val intent = Intent(this, MainActivity::class.java)
                Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show()

                startActivity(intent)
            } else {
                Toast.makeText(this, "Login Failed!", Toast.LENGTH_SHORT).show()
            }

        }
    }
}